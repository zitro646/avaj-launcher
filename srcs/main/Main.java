package main;

import AircraftFactory.AircraftFactory;
import Coordinates.Coordinates;
import Flyable.Flyable;
import Macros.Macros;
import WeatherTower.WeatherTower;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static WeatherTower la_torre = new WeatherTower();
    public static int n_rep = -1;

    public static void main(String[] args) {

        // Comprobante de fuck ups
        if (args.length != 1) {
            System.out.println("Usage: java main.Main <input-file>");
            return;
        }

        if (!processFile(args[0])) {
            System.out.println("Error: Data invalid");
            return;
        }
        for (int i = 0; i < n_rep; i++) {
            la_torre.changeWeather();
        }

    }

    //Esto lee el archivo
    private static boolean processFile(String inputFileName) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        String line;
        Flyable aux = null;
        int i = 0;
        boolean procesed = true;
        try {
            reader = new BufferedReader(new FileReader(inputFileName));
            writer = new BufferedWriter(new FileWriter(Macros.outputFileName)
            );

            while ((line = reader.readLine()) != null) {
                if (i == 0) {
                    try {
                        n_rep = Integer.parseInt(line);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: El numero de vueltas no se consiguio parsear a int");
                    }
                } else {
                    aux = processLine(line);
                    if (!aux.getErrorCoordinates()) {
                        la_torre.register(aux);
                    } else {
                        return false;
                    }
                }
                i++;
            }
        } catch (IOException e) {
            System.out.println("Error processing the file: " + e.getMessage());
            procesed = false;
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }

                if (writer != null) {
                    writer.close();
                }

            } catch (IOException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
        return procesed;
    }

    // Esto ta reducido de narices , pero convierte una linea a un objeto
    private static Flyable processLine(String line) {
        AircraftFactory factory = AircraftFactory.getInstance();
        String[] parts = line.split(" ");
        Coordinates c_aux = new Coordinates(Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
        Flyable aux = null;
        aux = factory.newAircraft(parts[0].toLowerCase(), parts[1], c_aux);
        return aux;
    }

}
