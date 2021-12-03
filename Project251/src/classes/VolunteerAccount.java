package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class VolunteerAccount extends Account {

    VolunteeringOpportunities opportunities;
     DealingWithFile dealingWithFile =  new DealingWithFile();
     
    public VolunteerAccount(){
        
    }

    public boolean registrationInVolunteeringOpportunites() {
        Scanner scanner = new Scanner(System.in);
        String collage ="";
        String type = "";
        System.out.println("Select the Collage: \n 1-FCIT \n 2-Sciences \n 3-engineering \n 4-management and economy");
        int chooise= scanner.nextInt();
        switch(chooise){
            case 1:
                collage="Fcit";
                break;
                case 2:
                collage="Sciences";
                break;
                case 3:
                collage="engineering";
                break;
                case 4:
                collage="management and economy";
                break;
                
        }
        System.out.println("Select the volunteering type: \n 1-Technical \n 2-organizational \n 3-Special needs \n 4-educational");
        int chooiseType= scanner.nextInt();
        switch(chooiseType){
            case 1:
                type="Technical";
                break;
                case 2:
                type="organizational";
                break;
                case 3:
                type="Special needs";
                break;
                case 4:
                type="educational";
                break;
                
        }        
        opportunities.PrintVolunteeringOpportunities(collage, type);
        System.out.println("Write the name of opportunitie: ");
        String OppName = scanner.next();
        String oppr = opportunities.returnVolunteeringOpportunitieInformation( collage,  type,  OppName);
//        System.out.println(opportunities.returnVolunteeringOpportunitieInformation( collage,  type,  OppName));

        String fileName = "Volunteer "+name+".txt";

        ArrayList<String> opp = dealingWithFile.readFile(fileName);
        if (checkNoConflict(opp , oppr)==false){
            System.out.println("There is conflict");
            return false;
        }
        int size = opp.size();
        
        opp.add(oppr);
        if (opp.size()== size)
            return false;
        dealingWithFile.saveFile(fileName, opp);
        System.out.println("Your registration has been successful");
        return true;

    }

    public boolean checkNoConflict(ArrayList<String> str ,String oppr ) {
        for (int i = 0 ; i<str.size();i++){
            String[] spilted = str.get(i).split(" ");
            String[] spilt = oppr.split(" ");
            if (spilted[4].equalsIgnoreCase(spilt[4])||spilted[5].equalsIgnoreCase(spilt[5]))
            {
                return false;
            }
        }
        

        return true;
    }

    public void showAllCerrtivecates() {

      }
    


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  
    
    

}
