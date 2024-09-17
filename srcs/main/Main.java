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

    //public static AircraftFactory factory = new AircraftFactory();
    //public static WeatherProvider tiempo = new WeatherProvider(100, 100, 100);
    public static WeatherTower la_torre = new WeatherTower();
    public static int n_rep = -1;

    public static void main(String[] args) {

        // Comprobante de fuck ups
        if (args.length != 1) {
            System.out.println("Usage: java main.Main <input-file>");
            return;
        }

        processFile(args[0]);
        //la_torre.show_Aircrafts();
        System.out.println("Vuelta " + n_rep);
        for (int i = 0; i < n_rep; i++) {
            //System.out.println("Vuelta " + i);
            la_torre.changeWeather();
        }

        System.out.println("Se finí ");

    }

    //Esto lee el archivo
    private static void processFile(String inputFileName) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        String line;
        int i = 0;
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
                    la_torre.register(processLine(line));
                }
                i++;
            }
        } catch (IOException e) {
            System.out.println("Error processing the file: " + e.getMessage());
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
