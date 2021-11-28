package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to KAU Volunteers Website");
        System.out.println("for Log in Enter 1 , for insert initiatives 2 ");
        
        int firstChooise= scanner.nextInt();
         switch (firstChooise) {
             case 1: 
        System.out.println("for the student enter 1 , admin enter 2");

        int choise = scanner.nextInt();

        switch (choise) {
            case 1:
                Account a = new Account();
                System.out.println("login select L, signup select S");
                String register = scanner.next();
                if (register.equals("L")) {
                    a.logIn();
                } else if (register.equals("S")) {
                    a.signUp();
                }
                else {
                    System.out.println("Wrong Chooise");
                }
                break;

            case 2:

                admin();
                CollageAdminstrator admin = new CollageAdminstrator();
                System.out.println("for add volunteering oppurtunites enter 1 , for manage Initiatives List enter 2 ");
                int functional = scanner.nextInt();
                if (functional == 1) {
                    admin.addVolunteeringOpportunitie();
                } else if (functional == 2) {

                } else {
                    System.out.println("Wrong Chooise");
                }
                break;

        }
        break;
             case 2:
                 Initiatives initiative = new Initiatives();
                 initiative.insertInitiatives();
                 break;
    }
    }

    public static void admin() {
        Scanner scanner = new Scanner(System.in);
        boolean counter = true;
        while (counter) {
            System.out.println("Enter your name:");
            String name = scanner.next();
            System.out.println("Enter your password:");
            String password = scanner.next();
            switch (name) {
                case "Fcit":
                    if (password.equals("1234Fcit")) {
                        counter = false;
                        break;
                    } else {
                        System.out.println("wrong password, please try again");
                        break;
                    }
                case "Sciences":
                    if (password.equals("1234Sciences")) {
                        counter = false;
                        break;
                    } else {
                        System.out.println("wrong password, please try again");
                        break;
                    }
                case "engineering":
                    if (password.equals("1234engineering")) {
                        counter = false;
                        break;
                    } else {
                        System.out.println("wrong password, please try again");
                        break;
                    }
                case "management and economy":
                    if (password.equals("1234managementeconomy")) {
                        counter = false;
                        break;
                    } else {
                        System.out.println("wrong password, please try again");
                        break;
                    }
                default:
                    System.out.println("wrong collage name");
                    break;
            }
        }
    }


         

}
