

import classes.VolunteerAccount;
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
    
    
    public TestVolunteerAccount() {
    }
    
    

    @Test
    public void TestregistrationInVolunteeringOpportunites() throws FileNotFoundException, IOException {
         TestVolunteerAccount test = new TestVolunteerAccount();
        String ID = "123456";
        String fileName = "Volunteer " + ID + ".txt";
        String oppr ="Special needs Exam 2 20 Feb10 Feb15";
        assertTrue(test.volunteer.registrationInVolunteeringOpportunites( fileName ,  oppr));
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
