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
    }

    protected void conditionChanged() {
        //System.out.println("Actualizamos los objetos de la lista (" + this.observers.size() + ")");
        if (observers.isEmpty()) {
            System.out.println("Tower says: Tower control here we dont see any aircrafts on the area.");
            return;
        }

        for (int i = 0; i < observers.size(); i++) {
            //System.out.println(observers.get(i).getDescripcion());
            observers.get(i).updateConditions();
            if (observers.get(i).getErrorCoordinates()) {
                System.out.println(observers.get(i).getDescripcion() + " landing.");
                observers.remove(i);
            }
        }
    }

    public void show_Aircrafts() {
        System.out.println("Actualizamos los objetos de la lista (" + this.observers.size() + ")");
        for (int i = 0; i < observers.size(); i++) {
            System.out.println("- - - - - - - - - - -");
            observers.get(i).mostrarInformacion();
        }
    }
}
