/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelmagic.objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import travelmagic.map.coordinate;

/**
 *
 * @author W
 */
public class TravelSystem {

    public static LinkedList<Attraction> attractionList = new LinkedList<Attraction>();

    public static LinkedList<Attraction> getAttractions() {
        return attractionList;
    }

    public static void addToAttractionList(String name, String description, double price, String weather, double budget, int space, String type, coordinate coordinate) {
        Attraction a = new Attraction(name, description, price, weather, budget, space, type, coordinate);
        attractionList.add(a);
    }

    public static LinkedList<Hotel> hotelList = new LinkedList<Hotel>();

    public static LinkedList<Hotel> getHotels() {
        return hotelList;
    }

    public static void addToHotelList(String name, String description, double price, int space, coordinate coordinate) {
        Hotel h = new Hotel(name, description, price, space, coordinate);
        hotelList.add(h);
    }

    public static LinkedList<User> userList = new LinkedList<User>();

    public static LinkedList<User> getUsers() {
        return userList;
    }

    public static void addToUserList(int id, String name) {
        User u = new User(id, name);
        userList.add(u);
    }

    public static LinkedList<Administrator> administratorList = new LinkedList<Administrator>();

    public static LinkedList<Administrator> getAdministrators() {
        return administratorList;
    }

    public static void addToAdministratorList(int id, String name, String passWord) {
        Administrator a = new Administrator(id, name, passWord);
        administratorList.add(a);
    }
    public static LinkedList<Reservation> reservationList = new LinkedList<Reservation>();

    public static LinkedList<Reservation> getReservations() {
        return reservationList;
    }

    public static void addToReservationList(String name, String phone, String personId, int space, String hotelName, int userId) {
        Reservation r = new Reservation(name, phone, personId, space, hotelName, userId);
        reservationList.add(r);
    }

    public static User user;

    public static void setUser(User aUser) {
        user = aUser;
    }

    public static User getUser() {
        return user;
    }

    public static void searilizeHotel(LinkedList<Hotel> hotelList) {
        try {
            FileOutputStream fileOut = new FileOutputStream("hotelList.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(hotelList);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
        }
    }

    public static void deserializeHotel() {

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("hotelList.dat"));

            hotelList = (LinkedList<Hotel>) in.readObject();
            in.close();
        } catch (Exception e) {
        }
    }

    public static void searilizeAttraction(LinkedList<Attraction> attractionList) {
        try {
            FileOutputStream fileOut = new FileOutputStream("attractionlList.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(attractionList);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
        }
    }

    public static void deserializeAttraction() {

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("attractionList.dat"));
            //while (!(in.readObject()).equals(null)){
            //hotelList.addLast(in.readObject()); 
            //}
            attractionList = (LinkedList<Attraction>) in.readObject();
            in.close();
        } catch (Exception e) {
        }
        /*return attractionList;*/
    }

    public static void searilizeUser(LinkedList<User> userList) {
        try {
            FileOutputStream fileOut = new FileOutputStream("userList.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(userList);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
        }
    }

    public static void /*LinkedList<User>*/ deserializeUser(/*LinkedList<User> userList*/) {

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("userList.dat"));
            //while (!(in.readObject()).equals(null)){
            //hotelList.addLast(in.readObject()); 
            //}
            userList = (LinkedList<User>) in.readObject();
            in.close();
        } catch (Exception e) {
        }
        /*return userList;*/

    }

    public static void searilizeAdministrator(LinkedList<Administrator> administratorList) {
        try {
            FileOutputStream fileOut = new FileOutputStream("administratorList.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(administratorList);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
        }
    }

    public static void /*LinkedList<Administrator>*/ deserializeAdministrator(/*LinkedList<Administrator> administratorList*/) {

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("administratorList.dat"));
            //while (!(in.readObject()).equals(null)){
            //hotelList.addLast(in.readObject()); 
            //}
            administratorList = (LinkedList<Administrator>) in.readObject();

            in.close();
        } catch (Exception e) {
        }
        /*return administratorList;*/
    }

    public static void /* LinkedList<Hotel>*/ deserializeReservation(/*LinkedList<Hotel> hotelList*/) {

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("reservationList.dat"));
            //while (!(in.readObject()).equals(null)){
            //hotelList.addLast(in.readObject()); 
            //}
            reservationList = (LinkedList<Reservation>) in.readObject();
            in.close();
        } catch (Exception e) {
        }
        /*return hotelList;*/
    }

    public static void searilizeReservation(LinkedList<Reservation> reservationList) {
        try {
            FileOutputStream fileOut = new FileOutputStream("reservationList.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(reservationList);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
        }
    }

    public static void outputPlan(LinkedList<Attraction> planList) {
        String planAttractions = "Route is:";
        Double planBudget = 0.0;
        int planDays = 0;
        String weather = "Weather will be:";
        PrintWriter output=null;
        try {
            output = new PrintWriter("plan.txt");
            for (Attraction a : planList) {
                planAttractions = planAttractions + a.getName() + " ";
                planBudget = planBudget + a.getBudget();
                planDays = planDays + a.getDay();
                weather = weather + a.getName() + ":" + a.getWeather() + ".\n";
            }
            output.print(planAttractions);
            output.print(planBudget);
            output.print(planDays);
            output.print(weather);        
            
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

}
