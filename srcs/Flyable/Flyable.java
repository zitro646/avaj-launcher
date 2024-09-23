package Flyable;

import WeatherTower.WeatherTower;

public abstract class Flyable {

    protected WeatherTower weathertower;

    public void registerTower(WeatherTower p_tower) {
        this.weathertower = p_tower;

        p_tower.register(this);
    }

    public abstract void updateConditions();

    public abstract String getDescripcion();

    public abstract boolean getErrorCoordinates();

}
