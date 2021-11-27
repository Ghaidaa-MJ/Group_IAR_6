
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
  
   
  // public VolunteeringOpportunities ( ArrayList<VolunteeringOpportunities> volunteeringOpportunities ){
      
  //}
   
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

    
    
    
         public static void AddVolunteeringOpportunities(String volunteeringType, String VolunteeringOpportunitiesName, int NumberOfVolunteers, String startDate, String endDate) {
        String str = volunteeringType + " " + VolunteeringOpportunitiesName + " " + VolunteeringOpportunitiesID++ + " " + NumberOfVolunteers + " " + startDate + " " + endDate;
        System.out.println(str);
        volunteeringOpportunities = readFile("opportunites.txt");
        volunteeringOpportunities.add(str);
        saveFile("opportunites.txt", volunteeringOpportunities);
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
