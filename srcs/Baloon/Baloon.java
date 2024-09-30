package Baloon;

import Aircraft.Aircraft;
import Coordinates.Coordinates;
import Macros.Macros;

public class Baloon extends Aircraft {

    public Baloon(String name, int id, Coordinates c) {
        super(name, id, c);
    }

    @Override
    public void updateConditions() {
        String aux = this.weathertower.getWeather(this.coordinates);
        Coordinates c_aux = null;

        switch (aux) {
            case Macros.SNOW:
                c_aux = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                Macros.writer.write(this.getDescripcion() + " : It's snowing. We're gonna crash.");
                break;
            case Macros.FOG:
                c_aux = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                Macros.writer.write(this.getDescripcion() + " : Lowering my altitude , this fog is too dense.");
                break;
            case Macros.RAIN:
                c_aux = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() + 5);
                Macros.writer.write(this.getDescripcion() + " : Damn you rain! You messed up my baloon.");
                break;
            case Macros.SUN:
                c_aux = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                Macros.writer.write(this.getDescripcion() + " : Let's enjoy the good weather and take some pics.");
                break;
        }
        this.coordinates = c_aux;
        return;
    }

    public String getDescripcion() {
        return "Baloon#" + this.name + "(" + this.id + ")";
    }
}
