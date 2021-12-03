
package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class DealingWithFile {
    
    public  DealingWithFile(){
        
    }
    
    
       public ArrayList<String> readFile(String filename) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            String record = "";
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((record = br.readLine()) != null) {
                lines.add(record);
            }
        } catch (Exception ex) {
        }

        return lines;

    }

    public static void saveFile(String filename, ArrayList<String> volunteeringOpportunities) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (int i = 0; i < volunteeringOpportunities.size(); i++) {
                writer.write(volunteeringOpportunities.get(i));
                writer.newLine();
            }
            writer.close();
        } catch (Exception ex) {
        }
    }
    
}
