
package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;

public class VolunteeringOpportunities {
    
    String volunteeringType;
    String VolunteeringOpportunitiesName;
    static int VolunteeringOpportunitiesID=1;
    int NumberOfVolunteers;
    String startDate;
    String endDate;
    static VolunteerAccount volunteer;
    static ArrayList<String> volunteeringOpportunities = new ArrayList<String>();
   
    
  public VolunteeringOpportunities (){
      
  }
  
  
   
  public void addVolunteer(VolunteerAccount volunteer){
      
  }

    public String getVolunteeringType() {
        return volunteeringType;
    }

    public void setVolunteeringType(String volunteeringType) {
        this.volunteeringType = volunteeringType;
    }

    public String getVolunteeringOpportunitiesName() {
        return VolunteeringOpportunitiesName;
    }

    public void setVolunteeringOpportunitiesName(String VolunteeringOpportunitiesName) {
        this.VolunteeringOpportunitiesName = VolunteeringOpportunitiesName;
    }

    public int getVolunteeringOpportunitiesID() {
        return VolunteeringOpportunitiesID;
    }

    public void setVolunteeringOpportunitiesID(int VolunteeringOpportunitiesID) {
        this.VolunteeringOpportunitiesID = VolunteeringOpportunitiesID;
    }

    public int getNumberOfVolunteers() {
        return NumberOfVolunteers;
    }

    public void setNumberOfVolunteers(int NumberOfVolunteers) {
        this.NumberOfVolunteers = NumberOfVolunteers;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    
    
        public static void AddVolunteeringOpportunities(String collage ,String volunteeringType, String VolunteeringOpportunitiesName, int NumberOfVolunteers, String startDate, String endDate) {
        String str = volunteeringType + " " + VolunteeringOpportunitiesName + " " + VolunteeringOpportunitiesID++ + " " + NumberOfVolunteers + " " + startDate + " " + endDate;
        System.out.println(str);
        String fileName = collage+" "+volunteeringType+" "+"opportunites.txt";
        volunteeringOpportunities = readFile(fileName);
        volunteeringOpportunities.add(str);
        saveFile(fileName, volunteeringOpportunities);
    }
        
        public static void PrintVolunteeringOpportunities(String collage, String type){
            String fileName = collage+" "+type+" opportunites.txt";
            ArrayList <String> opportunites = new ArrayList<>();
            opportunites= readFile(fileName);
            System.out.println("This is the opportunities Of "+ type +" type");
            System.out.println(opportunites);
        }
        
      public static String returnVolunteeringOpportunitieInformation(String collage, String type, String OppName) {
        String fileName = collage + " " + type + " opportunites.txt";
        ArrayList<String> opportunites = new ArrayList<>();
        opportunites = readFile(fileName);
        for (int i = 0; i < opportunites.size(); i++) {
            String[] spilted = opportunites.get(i).split(" ");
            if (spilted[1].equalsIgnoreCase(OppName)) {
                return opportunites.get(i);
            }
        }
        return null;
    }

         private static ArrayList<String> readFile(String filename) {
     
        try {
            String record = "";
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((record = br.readLine()) != null) {
                volunteeringOpportunities.add(record);
            }
        } catch (Exception ex) {
        }

        return volunteeringOpportunities;

    }

    private static void saveFile(String filename, ArrayList<String> volunteeringOpportunities) {
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
//---------------------------------------------------------------------------------
   
    
}
