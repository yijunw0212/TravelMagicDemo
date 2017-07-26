package travelmagic.objects;

import java.util.LinkedList;

public class RouteProcessor {

    private final LinkedList<Attraction> aList = TravelSystem.getAttractions();
    private String attractionPerference;
    private Attraction start;
    private Attraction destination;
    private LinkedList<Attraction> aAvailableList = new LinkedList<Attraction>();
    private double budget;

    public void setBudget(double abudget) {
        this.budget = abudget;
    }

    public void setAttractionPerference(String perference) {
        this.attractionPerference = perference;
    }

    public void setStart(Attraction aStart) {
        this.start = aStart;
    }

    public void setDestination(Attraction aDestination) {
        this.destination = aDestination;
    }

    private LinkedList<Attraction> setPerferenceAttraction() {    //删除不符合景点偏好的景点  第二步
        if (attractionPerference.equals("No special perference")) {
            return aAvailableList;
        } else {
            for (Attraction a : aAvailableList) {
                if (!((a.getType()).equals(attractionPerference))) {
                    aAvailableList.remove(a);
                }
            }
            return aAvailableList;
        }
    }

    private LinkedList<Attraction> setAttractionInArea() {  //设置在范围内的景点  第一步
        int x1 = start.getCoordinate().getX();
        int y1 = start.getCoordinate().getY();
        int x2 = destination.getCoordinate().getY();
        int y2 = destination.getCoordinate().getY();
        int biggerx=((x1>x2)?x1:x2);
        int biggery=((y1>y2)?y1:y2);
        int smallerx=((x1<x2)?x1:x2);
        int smallery=((y1<y2)?y1:y2);
        for (Attraction a : aList) {
            if (a.getCoordinate().getX() > smallerx) {
                if (a.getCoordinate().getY() > smallery) {
                    if (a.getCoordinate().getX() < biggerx) {
                        if (a.getCoordinate().getY() <biggery) {
                            aAvailableList.add(a);
                        }
                    }
                }
            }
        }
        return aAvailableList;
    }

    public LinkedList<Attraction> lowestPriceRoute() {
        setAttractionInArea();
        setPerferenceAttraction();
        Attraction temp;
        for (int i = 0; i < (aAvailableList.size() - 1); i++) {
            for (int j = i; j < aAvailableList.size(); j++) {
                if (aAvailableList.get(i).getBudget() > aAvailableList.get(j).getBudget()) {
                    temp = aAvailableList.get(i);
                    aAvailableList.set(i, aAvailableList.get(j));
                    aAvailableList.set(j, temp);
                }
            }
        }
        aAvailableList.add(0, start);
        aAvailableList.add(destination);
        return aAvailableList;
    }

    public LinkedList<Attraction> leastDaysRoute() {
        setAttractionInArea();
        setPerferenceAttraction();
        Attraction temp;
        for (int i = 0; i < (aAvailableList.size() - 1); i++) {
            for (int j = i; j < aAvailableList.size(); j++) {
                if (aAvailableList.get(i).getDay() > aAvailableList.get(j).getDay()) {
                    temp = aAvailableList.get(i);
                    aAvailableList.set(i, aAvailableList.get(j));
                    aAvailableList.set(j, temp);
                }
            }
        }
        aAvailableList.add(0, start);
        aAvailableList.add(destination);
        return aAvailableList;

    }

    public LinkedList<Attraction> noChoiceRoute() {
        setAttractionInArea();
        setPerferenceAttraction();
        aAvailableList.add(0, start);
        aAvailableList.add(destination);
        return aAvailableList;
    }

    public LinkedList<Attraction> limitedBudgetPlan(LinkedList<Attraction> tempPlan) {
        double tempBudget = 0;
        for (Attraction a : tempPlan) {
            tempBudget = tempBudget + a.getBudget();
            if (tempBudget > budget) {
                tempPlan.remove(a);
            }
        }
        return tempPlan;
    }
}
