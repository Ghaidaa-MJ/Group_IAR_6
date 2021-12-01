package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Account {

    String name;
    int phoneNumber;
    String email;
    String ID;
    int password;

    static ArrayList<String> volunteeringOpportunities = new ArrayList<String>();

    VolunteerAccount volunteer;
    VolunteeringOpportunities opportunities;

    public void logIn() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name:");
        name = scanner.next();
        System.out.println("Enter your password:");
        String password = scanner.next();

        String record = null;
        FileReader in = null;
        boolean found = false;
        try {
            //read the name and password from the file
            in = new FileReader("volunteer.txt");
            BufferedReader br = new BufferedReader(in);

            while ((record = br.readLine()) != null) {
                String[] split = record.split(" ");

                //check if username and password are valid
                if (name.equals(split[0]) && password.equals(split[1])) {
                    System.out.println(split[2]);
                    ID = split[2];
                    System.out.println("for register in Volunteering Opportunities you want select 1 \nfor Show all certificates select 2");
                    int choise = scanner.nextInt();
                    VolunteerAccount v = new VolunteerAccount();
                    v.setID(ID);
                    if (choise == 1) {
                        ///_____________________________________________

                        String collage = "";
                        String type = "";
                        System.out.println("Select the Collage: \n 1-FCIT \n 2-Sciences \n 3-engineering \n 4-management and economy");
                        collage = scanner.next();

                        System.out.println("Select the volunteering type: \n 1-Technical \n 2-organizational \n 3-Special needs \n 4-educational");
                        type = scanner.next();

                        opportunities.PrintVolunteeringOpportunities(collage, type);
                        System.out.println("Write the name of opportunitie: ");
                        String OppName = scanner.next();
                        String oppr = opportunities.returnVolunteeringOpportunitieInformation(collage, type, OppName);

                        String fileName = "Volunteer " + ID + ".txt";

                        ///_________________________________________________
                        v.registrationInVolunteeringOpportunites(fileName, oppr);
                    } else if (choise == 2) {
                        v.showAllCerrtivecates();
                    }
                    found = true;
                    break;
                }
            }
            //the username or password not found 
            if (found == false) {
                System.out.println("Wrong username or password");
            }
        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }

    public void signUp() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter your name:");
            name = scanner.next();
            System.out.println("Enter your ID:");
            ID = scanner.next();
            System.out.println("Enter your phone number:");
            phoneNumber = scanner.nextInt();
            System.out.println("Enter your email:");
            email = scanner.next();
            System.out.println("Enter your password:");
            String password = scanner.next();
            System.out.println("Confirm password:");
            String conPassword = scanner.next();

            //1-check if the username dose exists or not
            if (checkID(ID)) {
                System.out.println("ID alredy exists");
                return;
            }

            //2-check if the phone number is valid
            if (checkPhoneNumber(phoneNumber) == false) {
                System.out.println("Wrong phone number");
                return;
            }

            //3-check if the phone number is valid
            if (checkPassword(password, conPassword) == false) {
                System.out.println("The Password Is Mismatched");
                return;
            }
            updateRecord(name, ID, phoneNumber, email, password);
            System.out.println("for Choose the college you want select 1 \nfor Show all certificates select 2");
            int choise = scanner.nextInt();
            VolunteerAccount v = new VolunteerAccount();
            if (choise == 1) {
                ///_____________________________________________

                String collage = "";
                String type = "";
                System.out.println("Select the Collage: \n 1-FCIT \n 2-Sciences \n 3-engineering \n 4-management and economy");
                collage = scanner.next();

                System.out.println("Select the volunteering type: \n 1-Technical \n 2-organizational \n 3-Special needs \n 4-educational");
                type = scanner.next();

                opportunities.PrintVolunteeringOpportunities(collage, type);
                System.out.println("Write the name of opportunitie: ");
                String OppName = scanner.next();
                String oppr = opportunities.returnVolunteeringOpportunitieInformation(collage, type, OppName);

                String fileName = "Volunteer " + ID + ".txt";

                ///_________________________________________________
                v.registrationInVolunteeringOpportunites(fileName, oppr);
            } else if (choise == 2) {
                v.showAllCerrtivecates();
            }
        } catch (IOException ex) {
            System.out.println("ERROR");
        } catch (Exception ex) {
            System.out.println("ERROR");
        }

    }
//------------------------------------------------------------------------------------

    private boolean checkPhoneNumber(int PhoneNumber) {
        //check the length of the number
        if (Integer.toString(PhoneNumber).length() != 10) {
            return false;
        }
        return true;
    }
    //-----------------------------------------------------------------------------

    private boolean checkID(String id) throws Exception {
        ArrayList<String> lines = readFile("volunteer.txt");
        if (id.length() != 6) {
            return true;
        }
        for (int i = 0; i < lines.size(); i++) {
            String[] spilted = lines.get(i).split(" ");
            if (spilted[0].equals(id)) {
                return true;
            }
        }
        return false;
    }
//--------------------------------------------------------------------------------------

    private boolean checkPassword(String password, String conPassword) {
        if (!(password.equals(conPassword))) {
            return false;
        }
        return true;
    }
    //-----------------------------------------------------------------------

    private void updateRecord(String Name, String id, int phonenumber, String Email, String password) throws IOException {
        ArrayList<String> lines = readFile("login.txt");

        String newRecord = Name + " " + password + " " + id + " " + phonenumber + " " + Email;
        lines.add(newRecord);

        saveFile("volunteer.txt", lines);
    }
//------------------------------------------------------------------------

    private ArrayList<String> readFile(String filename) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            String record = "";
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((record = br.readLine()) != null) {
                lines.add(record);
            }
        } catch (Exception ex) {
        }

        return lines;

    }
//----------------------------------------------------------------------------------

    private void saveFile(String filename, ArrayList<String> lines) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (int i = 0; i < lines.size(); i++) {
                writer.write(lines.get(i));
                writer.newLine();
            }
            writer.close();
        } catch (Exception ex) {
        }

    }
}
