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
    String password;

    static ArrayList<String> volunteeringOpportunities = new ArrayList<String>();

    VolunteerAccount volunteer;
    VolunteeringOpportunities opportunities;
    DealingWithFile dealingWithFile = new DealingWithFile();

    public boolean logIn(String members, String name, String password) {

        String record = null;
        FileReader in = null;
        boolean found = false;
        try {
            //read the name and password from the file
            in = new FileReader(members + ".txt");
            BufferedReader br = new BufferedReader(in);

            while ((record = br.readLine()) != null) {
                String[] split = record.split(" ");

                //check if username and password are valid
                if (name.equals(split[0]) && password.equals(split[1])) {

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
        return found;
    }

    public String signUp(String name, String ID, int phoneNumber, String email, String password, String conPassword) {
        String str = "";

        try {

            //1-check if the username dose exists or not
            if (checkID(ID)) {
                System.out.println("ID alredy exists");
                str = "ID alredy exists";
                return str;
            }

            //2-check if the phone number is valid
            if (checkPhoneNumber(phoneNumber) == false) {
                System.out.println("Wrong phone number");
                str = "Wrong phone number";
                return str;
            }

            //3-check if the phone number is valid
            if (checkPassword(password, conPassword) == false) {
                System.out.println("The Password Is Mismatched");
                str = "The Password Is Mismatched";
                return str;
            }
            updateRecords(name, ID, phoneNumber, email, password);
            System.out.println("Your registration has been successful");
            str = "Your registration has been successful";
            return str;

        } catch (IOException ex) {
            System.out.println("ERROR");
        } catch (Exception ex) {
            System.out.println("ERROR");
        }
        return str;
    }
//------------------------------------------------------------------------------------

    public boolean checkPhoneNumber(int PhoneNumber) {
        //check the length of the number
        if (Integer.toString(PhoneNumber).length() != 10) {
            return false;
        }
        return true;
    }
    //-----------------------------------------------------------------------------

    public boolean checkID(String id) throws Exception {
        ArrayList<String> lines = dealingWithFile.readFile("volunteer.txt");
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

    public boolean checkPassword(String password, String conPassword) {
        if (!(password.equals(conPassword))) {
            return false;
        }
        return true;
    }
    //-----------------------------------------------------------------------

    public boolean updateRecords(String Name, String id, int phonenumber, String Email, String password) {
        ArrayList<String> lines = dealingWithFile.readFile("volunteer.txt");
        int size = lines.size();

        String newRecord = Name + " " + password + " " + id + " " + phonenumber + " " + Email;
        lines.add(newRecord);

        if (lines.size() == size) {
            return false;
        }

        dealingWithFile.saveFile("volunteer.txt", lines);
        return true;
    }

}
