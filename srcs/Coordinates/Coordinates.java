package Coordinates;

import javax.lang.model.util.ElementScanner14;

public class Coordinates {

    private int longitude;
    private int latitude;
    private int height;
    private boolean creation_error;

    public Coordinates(int lon, int lat, int h) {
        this.longitude = (lon < 0) ? 0 : lon;
        this.latitude = (lat < 0) ? 0 : lat;
        this.height = (h > 100) ? 100 : (h < 0) ? 0 : h;
        this.creation_error = (h < 0) ? true : false;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean getCreation_error() {
        return this.creation_error;
    }

    /*
    // Setters
    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        this.height = height;
    }
     */
}
