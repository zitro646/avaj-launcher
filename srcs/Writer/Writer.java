package Writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {


    private BufferedWriter writer = null;


    public Writer(String filename) {
        try{
            writer = new BufferedWriter(new FileWriter(filename));
        }
        catch(IOException e) 
        {
            System.out.println("Error creating resources: " + e.getMessage());
        }
    }

    public void write (String str){
        try
        {
            this.writer.write(str);
            this.writer.newLine();
        }
        catch(IOException e) 
        {
            System.out.println("Error writting line: " + e.getMessage());
        }
    }

    public void close(){
        try 
        {
            if (this.writer != null) {
                this.writer.close();
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Error closing resources: " + e.getMessage());
        }
    }
}
