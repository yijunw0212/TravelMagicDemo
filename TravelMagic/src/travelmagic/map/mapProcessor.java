/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelmagic.map;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Yijun
 */
public class mapProcessor {

      private BufferedImage map;// 地图对象
    private int viewportWidth;// 地图显示区的宽度
    private int viewportHeight;// 地图显示区的高度
    private int showCenterX;// 地图视觉中心的水平坐标
    private int showCenterY;// 地图视觉中心的垂直坐标
    private int cutMapWidth;// 截取地图的宽度
    private int cutMapHeight;// 截取地图的高度
    private float scale;// 缩放比例

    public mapProcessor(String mapPath, int viewportWidth, int viewportHeight, int scale) {
        this.viewportWidth = viewportWidth;
        this.viewportHeight = viewportHeight;
        replaceMap(mapPath);
        dealWithScale(scale);
        dealWithCutMapSize();
    }

    public void replaceMap(String mapPath) {
        try {
            map = ImageIO.read(new File(mapPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.showCenterX = map.getWidth() / 2;
        this.showCenterY = map.getHeight() / 2;
    }
    private ImageIcon cut() {
        
        BufferedImage subimage = map.getSubimage(
                showCenterX - cutMapWidth / 2, showCenterY - cutMapHeight / 2,// 开始截取点的坐标
                cutMapWidth, cutMapHeight);// 截取地图的大小

        return new ImageIcon(subimage.getScaledInstance(
                viewportWidth, viewportHeight, BufferedImage.SCALE_DEFAULT));// 返回当前显示的地图

    }

    public ImageIcon adjustScale(int scale) {
        float forestallScale = this.scale;// 调整前的比例

        dealWithScale(scale);// 处理比例

        dealWithCutMapSize();// 处理需要截取地图的大小

        if (this.scale < forestallScale) {// 比例缩小，地图的视觉中心可能变化

            validateShowCenterX();// 验证地图视觉中心的水平坐标

            validateShowCenterY();// 验证地图视觉中心的垂直坐标

        }
        return this.cut();// 返回当前显示的地图

    }

    public void adjustShowCenter(int x, int y) {
        this.showCenterX = x;
        this.showCenterY = y;
        validateShowCenterX();
        validateShowCenterY();
    }

    private void dealWithScale(int scale) {
        if (scale == 0) {// 不缩放

            this.scale = 0;
        } else {
            this.scale = scale / 100f;
            if (scale > 0) {// 放大

                this.scale += 1;
            } else {// 缩小

                this.scale -= 1;
            }
        }
    }

    private void validateShowCenterX() {
        int w = cutMapWidth / 2;
        if (cutMapWidth % 2 != 0) {
            w += 1;
        }
        if (showCenterX < w) {// 从地图左边缘开始截取

            showCenterX = w;
        } else {
            if (showCenterX > map.getWidth() - w) {// 截取至地图右边缘

                showCenterX = map.getWidth() - w;
            }
        }
    }

    private void validateShowCenterY() {
        int h = cutMapHeight / 2;
        if (cutMapHeight % 2 != 0) {
            h += 1;
        }
        if (showCenterY < h) {// 从地图上边缘开始截取

            showCenterY = h;
        } else {
            if (showCenterY > map.getHeight() - h) {// 截取至地图下边缘

                showCenterY = map.getHeight() - h;
            }
        }
    }

    private void dealWithCutMapSize() {
        if (scale == 0) {// 不缩放

            cutMapWidth = viewportWidth;
            cutMapHeight = viewportHeight;
        } else {
            if (scale > 0) {// 放大

                cutMapWidth = (int) (viewportWidth / scale);
                cutMapHeight = (int) (viewportHeight / scale);
            } else {// 缩小

                cutMapWidth = (int) (viewportWidth * -scale);
                cutMapHeight = (int) (viewportHeight * -scale);
            }
        }
    }

    public BufferedImage getMap() {
        return map;
    }

    public int getShowCenterX() {
        return showCenterX;
    }

    public int getShowCenterY() {
        return showCenterY;
    }

    public int getCutMapWidth() {
        return cutMapWidth;
    }

    public int getCutMapHeight() {
        return cutMapHeight;
    }

    public float getScale() {
        return scale;
    }

    public int parseScale(double scale) {
        if (scale == 0) {
            return 0;
        } else {
            if (scale > 0) {
                return (int) ((scale - 1) * 100);
            } else {
                return (int) ((scale + 1) * 100);
            }
        }
    }
    //

}
