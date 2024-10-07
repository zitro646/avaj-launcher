package main;

import AircraftFactory.AircraftFactory;
import Coordinates.Coordinates;
import Flyable.Flyable;
import Macros.Macros;
import WeatherTower.WeatherTower;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import Writer.Writer;

public class Main {

    public static WeatherTower la_torre = new WeatherTower();
    public static int n_rep = -1;

    public static void main(String[] args) {

        Macros.writer = new Writer(Macros.outputFileName);
        boolean procesed = false;
        // Comprobante de fuck ups
        if (args.length != 1) {
            Macros.writer.write("Usage: java main.Main <input-file>");
            return;
        }
        
        procesed = processFile(args[0]);
        if (!procesed) {
            set_up_error();
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
                        if (n_rep < 0)
                        {
                            System.out.println("Error: El numero de vueltas no se consiguio parsear a int");
                            return false;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: El numero de vueltas no se consiguio parsear a int");
                        return false;
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
        } catch (IOException e ) {
            System.out.println( "Error processing the file: " + e.getMessage());
            return false;
        }catch (AssertionError e) 
        {
            System.out.println( "Error processing the file: " + e.getMessage());
            return false;
        }
        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println( "Error closing resources: " + e.getMessage());
            }
        }
        return true;
    }

    // Esto ta reducido de narices , pero convierte una linea a un objeto
    private static Flyable processLine(String line) {
        AircraftFactory factory = AircraftFactory.getInstance();
        String[] parts = line.split(" ");
        if (parts.length != 5)
            throw new AssertionError("La línea no contiene suficientes partes.");

        try {
            Coordinates coordinates = new Coordinates(
                Integer.parseInt(parts[2]), 
                Integer.parseInt(parts[3]), 
                Integer.parseInt(parts[4])
            );
            return factory.newAircraft(parts[0].toLowerCase(), parts[1], coordinates);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Los valores de las coordenadas deben ser enteros.");
        }
    }
    

    private static void set_up_error() {
        Writer error = new Writer(Macros.outputFileName);
        error.write("Program stopped due to an error on input text");
        error.close();
        return;
    }


}
