
package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Initiatives {
    
   int initiativeID;
   String initiativeName;
   String initiativeIdea;
   int NumOfPeople;
   String date;
   int cost;
   String location;
   String VisionAndGoal;
   ArrayList <String> initiatives = new ArrayList();
   ArrayList <String> file = new ArrayList();
   Scanner scanner = new Scanner(System.in);
   Scanner scanner2 = new Scanner(System.in);

    public Initiatives() {
        
    }
   
   private Initiatives(int initiativeID, String initiativeName, String initiativeIdea, int NumOfPeople, int cost, String location, String VisionAndGoal) {
        
    }
   
    
    public void insertInitiatives(){
        String str = "";
        Initiatives initiative = new Initiatives ();
        String addOther = "yes";
        while (addOther=="yes"){
        System.out.println("Enter the name of Initiative: ");
        initiativeName= scanner2.nextLine();
        System.out.println("Enter the idea of Initiative: ");
        initiativeIdea = scanner2.nextLine();
            System.out.println("Enter the Number Of people: ");
            NumOfPeople = scanner.nextInt();
            System.out.println("Enter the cost: ");
            cost = scanner.nextInt();
            System.out.println("Enter the Location: ");
            location= scanner2.nextLine();
            System.out.println("Enter the Vision And Goal: ");
            VisionAndGoal= scanner2.nextLine();
            initiatives = readFile("initiatives.txt");
            initiativeID +=1;
            str =initiativeID + "-"+initiativeName+"-"+initiativeIdea+"-"+NumOfPeople+"-"+cost+"-"+location+"-"+VisionAndGoal;
            initiatives.add(str);
            System.out.println(initiatives.toString());
            
            
            saveFile("initiatives.txt", initiatives);
           
            System.out.println("Do you want to add other initiative?");
            addOther = scanner.next();
        
        
        
        
    }
    }
    //neme  , idea , num of people , cost , location , goal
   
    
    public boolean AcceptInitiative(){
        System.out.println("Initiatives");
        System.out.println("");
        ArrayList <String> str = new ArrayList<>();
        str = readFile("initiatives.txt");
        System.out.println(str);
       
       return false;//initial value
   }
    
      private ArrayList<String> readFile(String filename) {
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
  
//----------------------------------------------------------------------------------

    private void saveFile(String filename, ArrayList<String> lines) {
        try {
            
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (int i = 0; i < lines.size(); i++) {
                writer.write(lines.get(i));
                writer.newLine();
            }
            writer.close();
        } catch (Exception ex) {
        }
    }

    
    public int getInitiativeID() {
        return initiativeID;
    }

    public void setInitiativeID(int initiativeID) {
        this.initiativeID = initiativeID;
    }

    public String getInitiativeName() {
        return initiativeName;
    }

    public void setInitiativeName(String initiativeName) {
        this.initiativeName = initiativeName;
    }

    public String getInitiativeIdea() {
        return initiativeIdea;
    }

    public void setInitiativeIdea(String initiativeIdea) {
        this.initiativeIdea = initiativeIdea;
    }

    public int getNumOfPeople() {
        return NumOfPeople;
    }

    public void setNumOfPeople(int NumOfPeople) {
        this.NumOfPeople = NumOfPeople;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVisionAndGoal() {
        return VisionAndGoal;
    }

    public void setVisionAndGoal(String VisionAndGoal) {
        this.VisionAndGoal = VisionAndGoal;
    }

    @Override
    public String toString() {
        return  initiativeID + " " + initiativeName + " " + initiativeIdea + " " + NumOfPeople + " " + date + " " + cost + " " + location + " " + VisionAndGoal ;
    }
    
    
   
    
}
