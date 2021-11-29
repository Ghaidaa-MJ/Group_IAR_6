
package classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CollageAdminstrator  extends Account{
    
      VolunteeringOpportunities opportunities;
      Initiatives initiative;
      Scanner scanner = new Scanner(System.in);
      public CollageAdminstrator(){
          
      }
      
      public void addVolunteeringOpportunitie(){
          String str = "yes";
          while (str.equalsIgnoreCase("yes")){
           System.out.println("Select the volunteering type: \n 1-Technical \n 2-organizational \n 3-Special needs \n 4-educational");
           int typeNum = scanner.nextInt();
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
           String Vname = scanner.next();
           System.out.println("Write the Number of volunteers required: ");
           int NumberOfVolunteers = scanner.nextInt();
           System.out.println("Enter start date:");
           String startDate = scanner.next();
           System.out.println("Enter end date:");
           String endDate = scanner.next();

          opportunities.AddVolunteeringOpportunities(getName(),type , Vname, NumberOfVolunteers,startDate,endDate);
          
              System.out.println("Do you want to add other  Volunteering Opportunitie? ");
              str = scanner.next();
      }
          
      }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
      
      public void manageTheInitives(){
          initiative.AcceptInitiative();
          
      }
    
}
