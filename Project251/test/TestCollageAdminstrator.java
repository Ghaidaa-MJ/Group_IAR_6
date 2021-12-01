/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import classes.CollageAdminstrator;
import classes.Initiatives;
import classes.VolunteeringOpportunities;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class TestCollageAdminstrator {
     CollageAdminstrator admin = new CollageAdminstrator();
      VolunteeringOpportunities opportunities = new VolunteeringOpportunities();
      static Initiatives initiative = new Initiatives ();
    public TestCollageAdminstrator() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
     public boolean addVolunteeringOpportunitie(){
          boolean add= false;
          String str = "yes";
          while (str.equalsIgnoreCase("yes")){
           System.out.println("Select the volunteering type: \n 1-Technical \n 2-organizational \n 3-Special needs \n 4-educational");
           int typeNum = 2;
           String type="";
           switch(typeNum){
               case 1:
                   type= "Technical";
                   break;
               case 2:
                   type= "organizational";
                   break;
               case 3 :
                   type= "Special needs";
                   break;
               case 4:
                   type="educational";
                   break;
                   default :
                       System.out.println("Wrong selection");
                   
               
           }
           System.out.println("Write the Volunteering Opportunitie Name: ");
           String Vname = "ReadingDay";
           System.out.println("Write the Number of volunteers required: ");
           int NumberOfVolunteers = 15;
           System.out.println("Enter start date:");
           String startDate = "Nov16";
           System.out.println("Enter end date:");
           String endDate = "Nov19";

          add = opportunities.AddVolunteeringOpportunities("Fcit",type , Vname, NumberOfVolunteers,startDate,endDate);
          
              System.out.println("Do you want to add other  Volunteering Opportunitie? ");
              str ="No";
      }
          return add;
          
      }
    

    
     @Test
    public void TestAddVolunteeringOpportunitie() {
        
        assertTrue(addVolunteeringOpportunitie());
    
    }
    
    
    //Afforestation initiative-Afforestation in front of building 27-15-4000-front of building 27-Make a beautiful view of the eye
    
    public boolean manageTheInitives(){
          initiative.PrintInitiative();
          System.out.println("Enter the name of the initiative you have approved: ");
          String initiativeName = "Afforestation initiative";
          System.out.println("Write the Volunteering Type: ");
           String type = "organizational";
           System.out.println("Enter start date:");
           String startDate = "Sep5";
           System.out.println("Enter end date:");
           String endDate = "Sep7";
          String str = initiative.returnInitiative(initiativeName);
          String []split = str.split("-");
          
          return opportunities.AddVolunteeringOpportunities("Fcit",type , split[0], Integer.valueOf(split[2]),startDate,endDate);
          
      }
    
     @Test
     public void TestmanageTheInitives() {
        
        assertTrue(manageTheInitives());
    
    }

    
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
