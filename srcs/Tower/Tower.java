package Tower;

import Flyable.Flyable;
import java.util.ArrayList;
import java.util.List;

public class Tower {

    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        this.observers.add(p_flyable);
        System.out.println("Tower says: " + p_flyable.getDescripcion() + " registered to weather tower");
    }

    public void unregister(Flyable p_flyable) {
        this.observers.remove(p_flyable);
        System.out.println("Tower says: " + p_flyable.getDescripcion() + " unregistered from the weather tower");
        if (this.observers.isEmpty()) {
            System.out.println("Tower says: Tower control here we dont see anymore aircrafts on the area.");
        }
    }

    protected void conditionChanged() {

        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
            if (observers.get(i).getErrorCoordinates()) {
                System.out.println(observers.get(i).getDescripcion() + " landing.");
                observers.remove(i);
            }
        }
    }
}
