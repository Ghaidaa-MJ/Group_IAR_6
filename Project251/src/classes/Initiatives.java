
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
   int cost;
   String location;
   String VisionAndGoal;
   ArrayList <String> initiatives = new ArrayList();
   Scanner scanner = new Scanner(System.in);
   Scanner scanner2 = new Scanner(System.in);
   DealingWithFile dealingWithFile =  new DealingWithFile();

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
            initiatives = dealingWithFile.readFile("initiatives.txt");

            str =initiativeName+"-"+initiativeIdea+"-"+NumOfPeople+"-"+cost+"-"+location+"-"+VisionAndGoal;
            initiatives.add(str);
            System.out.println(initiatives.toString());
            
            
            dealingWithFile.saveFile("initiatives.txt", initiatives);
            System.out.println("Your suggestion has been submitted successfully");
            System.out.println("Do you want to add other initiative?");
            addOther = scanner.next();
        
        
        
        
    }
    }
    
   
    public void PrintInitiative(){
        System.out.println("Initiatives");
        System.out.println("");
        ArrayList <String> str = new ArrayList<>();
        str = dealingWithFile.readFile("initiatives.txt");
        System.out.println(str);
    }
    
     public String returnInitiative(String initiativeName) {
        String fileName = "initiatives.txt";
        ArrayList<String>  initiatives = new ArrayList<>();
         initiatives = dealingWithFile.readFile(fileName);
        for (int i = 0; i <  initiatives.size(); i++) {
            String[] spilted =  initiatives.get(i).split("-");
            if (spilted[0].equalsIgnoreCase( initiativeName)) {
                return  initiatives.get(i);
            }
        }
        return null;
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
        return  initiativeID + " " + initiativeName + " " + initiativeIdea + " " + NumOfPeople + " " + cost + " " + location + " " + VisionAndGoal ;
    }
    
    
   
    
}
