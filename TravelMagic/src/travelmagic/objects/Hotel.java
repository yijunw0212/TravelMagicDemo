package travelmagic.objects;

import travelmagic.map.coordinate;

public class Hotel implements java.io.Serializable{

    private String name;
    private String description;
    private double price;
    private int space;
    private final coordinate coordinate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public Hotel(String name, String description, double price, int space, coordinate coordinate) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.space = space;
        this.coordinate = coordinate;
    }

    public coordinate getCoordinate() {
        return coordinate;
    }

    public String toString() {
        return "Hotel name is" + name + ", average price per night is" + price + " space available is" + space + ", coordinate is" + coordinate.toString();
    }
}
