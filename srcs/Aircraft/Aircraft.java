package Aircraft;

import Coordinates.Coordinates;
import Flyable.Flyable;

public abstract class Aircraft extends Flyable {

    protected String name;
    protected long id;
    protected Coordinates coordinates;

    protected Aircraft(String p_name, int p_id, Coordinates p_coor) {
        this.name = p_name;
        this.id = p_id;
        this.coordinates = p_coor;
    }

    public boolean getErrorCoordinates() {
        return this.coordinates.getCreation_error();
    }

    //Eliminar esto despues de quitar debug
    public void mostrarInformacion() {
        System.out.println("Nombre: " + name);
        System.out.println("id: " + id);
        System.out.println("Longitud: " + coordinates.getLongitude());
        System.out.println("Latitud: " + coordinates.getLatitude());
        System.out.println("Altura: " + coordinates.getHeight());
    }

}
