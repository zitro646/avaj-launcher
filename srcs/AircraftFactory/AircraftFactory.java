package AircraftFactory;

import Baloon.Baloon;
import Coordinates.Coordinates;
import Flyable.Flyable;
import Helicopter.Helicopter;
import JetPlane.JetPlane;

public class AircraftFactory {

    private static int id_row = 1;
    private static AircraftFactory instance;

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_Coordinates) {
        Flyable aux = null;
        switch (p_type) {
            case "baloon":
                aux = new Baloon(p_name, AircraftFactory.id_row, p_Coordinates);
                break;
            case "helicopter":
                aux = new Helicopter(p_name, AircraftFactory.id_row, p_Coordinates);
                break;
            case "jetplane":
                aux = new JetPlane(p_name, AircraftFactory.id_row, p_Coordinates);
                break;
            default:
                throw new AssertionError();
        }
        AircraftFactory.id_row++;
        return aux;
    }

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

}
