
package classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CollageAdminstrator  extends Account{
    
      VolunteeringOpportunities opportunities;
      static Initiatives initiative = new Initiatives ();
      Scanner scanner = new Scanner(System.in);
      Scanner scanner2 = new Scanner(System.in);
      public CollageAdminstrator(){
          
      }
      
      public boolean addVolunteeringOpportunitie(){
          boolean add= false;
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

          add = opportunities.AddVolunteeringOpportunities(getName(),type , Vname, NumberOfVolunteers,startDate,endDate);
          
              System.out.println("Do you want to add other  Volunteering Opportunitie? ");
              str = scanner.next();
      }
          return add;
          
      }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
      
      public boolean manageTheInitives(){
          
          
          initiative.PrintInitiative();
          System.out.println("Enter the name of the initiative you have approved: ");
          String initiativeName = scanner2.nextLine();
          System.out.println("Write the Volunteering Type: ");
           String type = scanner.next();
           System.out.println("Enter start date:");
           String startDate = scanner.next();
           System.out.println("Enter end date:");
           String endDate = scanner.next();
          String str = initiative.returnInitiative(initiativeName);
          String []split = str.split("-");
          
         return opportunities.AddVolunteeringOpportunities(getName(),type , split[0], Integer.valueOf(split[2]),startDate,endDate);
         
          
          
          
      }
    
}
