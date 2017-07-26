/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package travelmagic.map;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author Yijun
 */
public class HotelLabel extends JLabel {
        protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawRect(g);

             
        }
    
    private void drawRect(Graphics g) {
       
        g.setColor(Color.RED);

        g.fillRect(0,0,10,10);

    }
}
