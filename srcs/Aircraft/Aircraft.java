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

    @Override
    public boolean getErrorCoordinates() {
        return this.coordinates.getCreation_error();
    }

}
