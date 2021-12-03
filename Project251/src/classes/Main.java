package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static VolunteerAccount v = new VolunteerAccount();
    static CollageAdminstrator admin = new CollageAdminstrator();
    static Account a = new Account();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to KAU Volunteers Website");
        System.out.println("for the student enter 1 , admin enter 2");

        int choise1 = scanner.nextInt();

        switch (choise1) {
            case 1:

                System.out.println("login select L, signup select S");
                String register = scanner.next();
                if (register.equals("L")) {

                    System.out.println("Enter your name:");
                    String name = scanner.next();
                    System.out.println("Enter your password:");
                    String password = scanner.next();
                    a.logIn("volunteer", name, password);
                    v.setName(name);
                    System.out.println("for register in Volunteering Opportunities you want select 1 \nfor Show all certificates select 2 \nfor suggest initiatives select 3");
                    int choise = scanner.nextInt();

                    if (choise == 1) {
                        v.registrationInVolunteeringOpportunites();
                    } else if (choise == 2) {
                        v.showAllCerrtivecates();
                    } else if (choise == 3) {
                        Initiatives initiative = new Initiatives();
                        initiative.insertInitiatives();

                    }
                } else if (register.equals("S")) {
                    
                    System.out.println("Enter your name:");
                    String name = scanner.next();
                    System.out.println("Enter your ID:");
                    String ID = scanner.next();
                    System.out.println("Enter your phone number:");
                    int phoneNumber = scanner.nextInt();
                    System.out.println("Enter your email:");
                    String email = scanner.next();
                    System.out.println("Enter your password:");
                    String password = scanner.next();
                    System.out.println("Confirm password:");
                    String conPassword = scanner.next();
                    a.signUp(name, ID, phoneNumber, email, password, conPassword);
                } else {
                    System.out.println("Wrong Chooise");
                }
                break;

            case 2:

                System.out.println("Enter your name:");
                String name = scanner.next();
                System.out.println("Enter your password:");
                String password = scanner.next();

                a.logIn("admin", name, password);
                admin.setName(name);
                System.out.println("for add volunteering oppurtunites enter 1 , for manage Initiatives List enter 2 ");
                int functional = scanner.nextInt();
                if (functional == 1) {
                    admin.addVolunteeringOpportunitie();
                } else if (functional == 2) {
                    admin.manageTheInitives();
                } else {
                    System.out.println("Wrong Chooise");
                }
                break;

        }

    }
}
