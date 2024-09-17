package AircraftFactory;

import Aircraft.Aircraft;
import Coordinates.Coordinates;
import Baloon.Baloon;
import Helicopter.Helicopter;
import JetPlane.JetPlane;
import Flyable.Flyable;

public class AircraftFactory {

    private static int id_row = 1;
    private static AircraftFactory instance;

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_Coordinates) {
        Flyable aux = null;
        switch (p_type) {
            case "baloon":
                aux = new Baloon(p_name, this.id_row, p_Coordinates);
                break;
            case "helicopter":
                aux = new Helicopter(p_name, this.id_row, p_Coordinates);
                break;
            case "jetplane":
                aux = new JetPlane(p_name, this.id_row, p_Coordinates);
                break;
            default:
                throw new AssertionError();
        }
        this.id_row++;
        return aux;
    }

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

}
