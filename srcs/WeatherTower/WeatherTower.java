package WeatherTower;

import Coordinates.Coordinates;
import Tower.Tower;
//import WeatherProvider.WeatherProvider;

public class WeatherTower extends Tower {

    public static String getWeather(Coordinates p_coor) {
        return "test";
    }

    public void changeWeather() {
        //WeatherProvider weather = WeatherProvider.getInstance(100);
        //weather.updateClimate();
        //System.out.println("Clima actualizado ");
        this.conditionChanged();
    }

}
