package Coordinates;

public class Coordinates {

    private final int longitude;
    private final int latitude;
    private final int height;
    private final boolean creation_error;

    public Coordinates(int lon, int lat, int h) {
        this.longitude = (lon < 0) ? 0 : lon;
        this.latitude = (lat < 0) ? 0 : lat;
        this.height = (h > 100) ? 100 : (h < 0) ? 0 : h;
        this.creation_error = (lon < 0 || lat < 0 || h < 0);
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

}
