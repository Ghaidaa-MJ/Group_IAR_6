
package classes;

import java.util.Scanner;


public class Main {
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to KAU Volunteers Website");
        System.out.println("for the student enter 1 , admin enter 2");

        int choise = scanner.nextInt();
        
        switch (choise){
            case 1:
                
                break;
                
            case 2:
                 CollageAdminstrator admin = new CollageAdminstrator();
                System.out.println("for add volunteering oppurtunites enter 1 , for manage Initiatives List enter 2 ");
                int functional = scanner.nextInt();
                if (functional== 1){
                    admin.addVolunteeringOpportunitie();
                }else if (functional==2){
                    
                }else 
                    System.out.println("Wrong Chooise");
                break;
        }
        
        
    
      

    }
}
