package WeatherProvider;

import Coordinates.Coordinates;
import Macros.Macros;
import java.util.Random;

public class WeatherProvider {

    private static WeatherProvider instance;
    private static final String[] weatherTypes = {Macros.RAIN, Macros.FOG, Macros.SUN, Macros.SNOW};

    public WeatherProvider() {
        return;
    }

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates c) {
        Random random = new Random();
        return WeatherProvider.weatherTypes[random.nextInt(4)];

    }
}
