package WeatherProvider;

import Coordinates.Coordinates;
import java.util.Random;
import Macros.Macros;

public class WeatherProvider {

    private static WeatherProvider instance;
    private static final String[] weatherTypes = {Macros.RAIN, Macros.FOG, Macros.SUN, Macros.SNOW};

    /* Tipos de clima posibles
    private int dimX;
    private int dimY;
    private int dimZ;
    int[][][] temperatura = null;
    int[][][] humedad = null;
     */
    public WeatherProvider() {
        /*this.dimX = dimX;
        this.dimY = dimY;
        this.dimZ = dimZ;
        System.out.println("Generamos el coso: ");
        this.temperatura = this.alterClimate(this.initialiceClimate(), 25);
        this.humedad = this.alterClimate(this.initialiceClimate(), 25);
        System.out.println("Clima generado ");
        
        // Imprimir el array 3D con los gusanos
            for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                for (int k = 0; k < dimZ; k++) {
                    System.out.print(temperatura[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println("-----");
        }

    

         */
    }

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates c) {
        Random random = new Random();
        return this.weatherTypes[random.nextInt(4)];

        /* Quiero esto pero jode un poco las cosas
        int c_temp = temperatura[c.getLatitude()][c.getLongitude()][c.getHeight()];
        int c_humidity = humedad[c.getLatitude()][c.getLongitude()][c.getHeight()];
        if (c_temp <= 1 && c_humidity > 7) {
            return "Nieve";
        } else if (c_temp <= 3 && c_humidity > 7) {
            return "Niebla";

        } else if (c_temp > 3 && c_humidity > 6) {
            return "Lluvia";
        } else {
            return "Sol";
        }
         */
    }

    /*
    private int[][][] initialiceClimate() {
        int[][][] aux = new int[this.dimX][this.dimY][this.dimZ];

        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                for (int k = 0; k < dimZ; k++) {
                    aux[i][j][k] = 0;
                }
            }
        }
        return aux;
    }

    private int[][][] alterClimate(int[][][] aux, int worms) {
        Random random = new Random();
        int media = 5;
        int alter;
        int x;
        int y;
        int z;
        int length;
        for (int g = 0; g < worms; g++) { // g < numero de gusanos
            length = (random.nextInt(15)) + 10;  // Longitud del gusano entre 3 y 7
            x = random.nextInt(this.dimX);
            y = random.nextInt(this.dimY);
            z = random.nextInt(this.dimZ);

            for (int i = 0; i < length; i++) {
                alter = random.nextInt(3);
                /*
                if (random.nextInt(2) == 1) {
                    if (media + alter > 10) {
                        aux[x][y][z] = 10;
                    } else {
                        aux[x][y][z] = media + alter;
                    }

                } else {
                    if (media - alter < 0) {
                        aux[x][y][z] = 0;
                    } else {
                        aux[x][y][z] = media - alter;
                    }
                }
                 ///////////////////////////
                aux[x][y][z] = 10;
                applyHeatPoint(aux, x, y, z, aux[x][y][z]);
                switch (random.nextInt(3)) { //Tomamos una direccion
                    case 0:  // Moverse en el eje X
                        x = (x + 1) % dimX;
                        break;
                    case 1:  // Moverse en el eje Y
                        y = (y + 1) % dimY;
                        break;
                    case 2:  // Moverse en el eje Z
                        z = (z + 1) % dimZ;
                        break;
                }
            }

        }
        return aux;
    }
     
    public void updateClimate() {
        this.humedad = this.alterClimate(this.humedad, 2);
        this.temperatura = this.alterClimate(this.temperatura, 2);
    }
    
    private static void applyHeatPoint(int[][][] array, int x, int y, int z, int maxHeatValue) {
        int dimX = array.length;
        int dimY = array[0].length;
        int dimZ = array[0][0].length;

        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                for (int k = 0; k < dimZ; k++) {
                    // Calcular la distancia euclidiana desde el punto de calor
                    double distance = Math.sqrt(Math.pow(i - x, 2) + Math.pow(j - y, 2) + Math.pow(k - z, 2));
                    int heatValue = (int) Math.max(0, maxHeatValue - Math.round((float) distance));

                    // Si el nuevo valor es mayor, actualiza la celda
                    if (heatValue > array[i][j][k]) {
                        array[i][j][k] = heatValue;
                    }
                }
            }
        }
    }
     */
}
