package Helicopter;

import Aircraft.Aircraft;
import Coordinates.Coordinates;
import Macros.Macros;

public class Helicopter extends Aircraft {

    public Helicopter(String name, int id, Coordinates c) {
        super(name, id, c);
    }

    @Override
    public void updateConditions() {
        String aux = this.weathertower.getWeather(this.coordinates);
        Coordinates c_aux = null;

        switch (aux) {
            case Macros.SNOW:
                c_aux = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                System.out.println(this.getDescripcion() + " : My rotor is going to freeze!");
                break;
            case Macros.FOG:
                c_aux = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                System.out.println(this.getDescripcion() + " : Damm fog i cant see a thing");
                break;
            case Macros.RAIN:
                c_aux = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
                System.out.println(this.getDescripcion() + " : Its raining like crazy i hope all is ok");
                break;
            case Macros.SUN:
                c_aux = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                System.out.println(this.getDescripcion() + " : This is hot");
                break;
        }
        this.coordinates = c_aux;
        return;
    }

    public String getDescripcion() {
        return "Helicopter#" + this.name + "(" + this.id + ")";
    }
}
