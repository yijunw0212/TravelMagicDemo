package travelmagic.objects;

import travelmagic.GUI.MainForm;

public class TravelMagic {

    public static void main(String[] args) {
            
        new MainForm().setVisible(true);
        TravelSystem.deserializeHotel();
        TravelSystem.deserializeAttraction();
        TravelSystem.deserializeAdministrator();
        TravelSystem.deserializeUser();
        TravelSystem.deserializeReservation();
    }

}
