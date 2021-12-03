

import classes.Account;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestAccount {
    
    Account account = new Account();
    
    public TestAccount() {
    }
    
//    @Test
//    public void TestLogin(){
//        TestAccount test = new TestAccount();
//        String members = "volunteer";
//        String name = "Ghaidaa";
//        String password = "1234";
//        assertTrue(test.account.logIn(members, name, password));
//    }
//    
//    
//     @Test
//    public void TestSignUp(){
//        TestAccount test = new TestAccount();
//                    String name = "sara";
//                    String ID = "123454";       
//                    int phoneNumber = 1234567890;
//                    String email = "sAlharthi@gmail.com";
//                    String password = "1234";
//                    String conPassword = "1234";
//                    
//                    
//                    String str = account.signUp(name, ID, phoneNumber, email, password, conPassword);
//                    assertEquals("Your registration has been successful",account.signUp(name, ID, phoneNumber, email, password, conPassword));
//        //"Your registration has been successful"
//    }
//    
//     @Test
//    public void TestCheckPhoneNumber(){
//         TestAccount test = new TestAccount();
//         assertTrue(test.account.checkPhoneNumber(1234567890));
//        
//        
//    }
    
    
    @Test
    public void TestCheckID() throws Exception {
        TestAccount test = new TestAccount();
        String Id = "123456";
        assertFalse(test.account.checkID(Id));

    }
    
    @Test
    public void TestCheckPassword() {
        TestAccount test = new TestAccount();
        String password = "1234";
        String conPassword = "1234";
        assertTrue(test.account.checkPassword( password,  conPassword));

    }
    
    public void TestupdateRecords() {
        TestAccount test = new TestAccount();
        String name = "reem";
        String id = "124578";
        int phoneNumber = 1234567890;
        String email = "r@gmail.com";
        String password = "1234";
        assertTrue(test.account.updateRecords( name,  id,  phoneNumber,  email,  password));

    }
    
    
    
    //updateRecords(String Name, String id, int phonenumber, String Email, String password)/true
    
    
    
    

}
