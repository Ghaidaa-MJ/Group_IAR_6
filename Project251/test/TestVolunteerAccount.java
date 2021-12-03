

import classes.DealingWithFile;
import classes.VolunteerAccount;
import classes.VolunteeringOpportunities;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestVolunteerAccount {
    
    VolunteerAccount volunteer = new VolunteerAccount();
    VolunteeringOpportunities opportunities;
    DealingWithFile dealingWithFile =  new DealingWithFile();
    
    public TestVolunteerAccount() {
    }
    
    
      public boolean registrationInVolunteeringOpportunites() {
        
        String collage ="";
        String type = "";
        System.out.println("Select the Collage: \n 1-FCIT \n 2-Sciences \n 3-engineering \n 4-management and economy");
        int chooise= 1;
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
        int chooiseType= 1;
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
        String OppName = "support";
        String oppr = opportunities.returnVolunteeringOpportunitieInformation( collage,  type,  OppName);


        String fileName = "Volunteer "+"Ghaidaa"+".txt";

        ArrayList<String> opp = dealingWithFile.readFile(fileName);
        if (volunteer.checkNoConflict(opp , oppr)==false){
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
    
    

    @Test
    public void TestregistrationInVolunteeringOpportunites() throws FileNotFoundException, IOException {
         TestVolunteerAccount test = new TestVolunteerAccount();
        assertTrue(test.registrationInVolunteeringOpportunites());
    }
   
    
    @Test
  public void TestCheckNoConflict(){
       TestVolunteerAccount test = new TestVolunteerAccount();
      ArrayList<String> opportunitiesForVolunteer = new ArrayList<>();
      opportunitiesForVolunteer.add("organizational NationalDay 1 10 Sep20 Sep22");
      opportunitiesForVolunteer.add("Technical support 1 15 Nov23 Nov28"); 
      
      String opportunitie = "educational CPIT210 3 5 Nov20 Nov30";
       assertTrue(test.volunteer.checkNoConflict(opportunitiesForVolunteer ,opportunitie));
       
  }
    
}
