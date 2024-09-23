package WeatherTower;

import Coordinates.Coordinates;
import Tower.Tower;
import WeatherProvider.WeatherProvider;

public class WeatherTower extends Tower {

    public static String getWeather(Coordinates p_coor) {
        WeatherProvider weather = WeatherProvider.getInstance();
        String aux = weather.getCurrentWeather(p_coor);
        return aux;
    }

    public void changeWeather() {
        this.conditionChanged();
    }

}
