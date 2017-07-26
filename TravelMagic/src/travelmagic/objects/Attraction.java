package travelmagic.objects;

import travelmagic.map.coordinate;

public class Attraction implements java.io.Serializable{

    private String name;
    private String description;
    private double gasPrice;
    private String weather;
    private double budget;
    private int day;
    private String type;
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

    public double getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Attraction(String name, String description, double gasPrice, String weather, double budget, int day, String type,coordinate coordinate) {
        this.name = name;
        this.description = description;
        this.gasPrice = gasPrice;
        this.weather = weather;
        this.budget = budget;
        this.day = day;
        this.type=type;
        this.coordinate = coordinate;
    }

    public coordinate getCoordinate() {
        return coordinate;
    }

    public String toString() {
        return "Attraction name is " + name + ", gas price nearby is" + gasPrice + ", weather is" + weather + ", estimated budget for this attraction per person is" + budget + ", estimated days for this attraction is" + day+", this attraction's type is"+type+", coordinate is"+coordinate.toString();
    }
}
