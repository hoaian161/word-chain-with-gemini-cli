package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Hoai An - CE190990
 */
public class Database {
    Database(){}
    
    public static ArrayList<String> get(String path){
        ArrayList<String> result = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(
            new FileReader(
                "database/" + path + ".txt"
            )
        )){
            String line;
            while ((line = br.readLine()) != null)
                result.add(line);
        } catch(IOException e){
            return result;
        }
        
        return result;
    }
    
    public static void set(String path, String data){
        try(FileWriter writer = new FileWriter("database/" + path + ".txt")) {
            writer.write(data);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
