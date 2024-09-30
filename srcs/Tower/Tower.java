package Tower;

import Flyable.Flyable;
import java.util.ArrayList;
import java.util.List;
import Macros.Macros;

public class Tower {

    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        this.observers.add(p_flyable);
        Macros.writer.write("Tower says: " + p_flyable.getDescripcion() + " registered to weather tower");
    }

    public void unregister(Flyable p_flyable) {
        this.observers.remove(p_flyable);
        Macros.writer.write("Tower says: " + p_flyable.getDescripcion() + " unregistered from the weather tower");
        if (this.observers.isEmpty()) {
            Macros.writer.write("Tower says: Tower control here we dont see anymore aircrafts on the area.");
        }
    }

    protected void conditionChanged() {

        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
            if (observers.get(i).getErrorCoordinates()) {
                Macros.writer.write(observers.get(i).getDescripcion() + " landing.");
                observers.remove(i);
            }
        }
    }
}
