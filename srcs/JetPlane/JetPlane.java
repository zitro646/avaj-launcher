package JetPlane;

import Aircraft.Aircraft;
import Coordinates.Coordinates;
import Macros.Macros;

public class JetPlane extends Aircraft {

    public JetPlane(String name, int id, Coordinates c) {
        super(name, id, c);
    }

    @Override
    public void updateConditions() {
        String aux = this.weathertower.getWeather(this.coordinates);
        Coordinates c_aux = null;

        switch (aux) {
            case Macros.SNOW:
                c_aux = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
                System.out.println(this.getDescripcion() + " : OMG! Winter is coming!");

                break;
            case Macros.FOG:
                c_aux = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                System.out.println(this.getDescripcion() + " : I have no visibility at all , whats my status CT?");

                break;
            case Macros.RAIN:
                c_aux = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
                System.out.println(this.getDescripcion() + " : It's raining. Better watch out for lightings.");

                break;
            case Macros.SUN:
                c_aux = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                System.out.println(this.getDescripcion() + " : Its sunny , what a good day.");

                break;
        }
        this.coordinates = c_aux;
        return;

    }

    public String getDescripcion() {
        return "JetPlane#" + this.name + "(" + this.id + ")";
    }
}
