package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Nguyen Hoai An - CE190990
 */
public class Server {
    Server(){}
    
    public static String curl(String parms){
        String serverURL = "INSERT URL HERE";
        try {
            URL url = new URL(serverURL + "?data=" + parms); // API, CURL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder content = new StringBuilder();
            String line;

            while((line = reader.readLine()) != null){
                content.append(line);
                content.append(System.lineSeparator());
            }
            reader.close();
            return content.toString().replaceAll("[\\r\\n]", "");

        } catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }
    
    public static String sendTurn(String text){
        return curl(text);
    }
}
