package main;

import AircraftFactory.AircraftFactory;
import Coordinates.Coordinates;
import Flyable.Flyable;
import Macros.Macros;
import WeatherTower.WeatherTower;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Writer.Writer;

public class Main {

    public static WeatherTower la_torre = new WeatherTower();
    public static int n_rep = -1;

    public static void main(String[] args) {

        Macros.writer = new Writer(Macros.outputFileName);
        // Macros.writer.write("JUAN ARREGLA TODO");
        // Macros.writer.write("CON MIRAR MI CODIGO");
        // Macros.writer.write("EH VERDA");
        // Macros.writer.write("Archivo para leer");
        // Comprobante de fuck ups
        if (args.length != 1) {
            Macros.writer.write("Usage: java main.Main <input-file>");
            return;
        }

        if (!processFile(args[0])) {
            Macros.writer.write("Error: Data invalid");
            return;
        }
        for (int i = 0; i < n_rep; i++) {
            la_torre.changeWeather();
        }
        Macros.writer.close();

    }

    //Esto lee el archivo
    private static boolean processFile(String inputFileName) {
        BufferedReader reader = null;
        
        String line;
        Flyable aux = null;
        int i = 0;
        boolean procesed = true;
        try {
            reader = new BufferedReader(new FileReader(inputFileName));
            

            while ((line = reader.readLine()) != null) {
                if (i == 0) {
                    try {
                        n_rep = Integer.parseInt(line);
                    } catch (NumberFormatException e) {
                        Macros.writer.write("Error: El numero de vueltas no se consiguio parsear a int");
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
            Macros.writer.write("Error processing the file: " + e.getMessage());
            procesed = false;
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }

                

            } catch (IOException e) {
                Macros.writer.write("Error closing resources: " + e.getMessage());
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
