
import classes.VolunteeringOpportunities;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestVolunteeringOpportunities {

    VolunteeringOpportunities Opportunities = new VolunteeringOpportunities();

    

    @Test
    public void TestAddVolunteeringOpportunities() {
        TestVolunteeringOpportunities test = new TestVolunteeringOpportunities();
        
        assertTrue(test.Opportunities.AddVolunteeringOpportunities("FCIT", "Technical", "support", 15, " Nov23", " Nov28"));

    }
    
     @Test
    public void TestPrintVolunteeringOpportunities(){
         TestVolunteeringOpportunities test = new TestVolunteeringOpportunities();
        
        assertNotNull(test.Opportunities.PrintVolunteeringOpportunities("FCIT", "organizational"));
        
    }
    
    
    @Test
    public void TestReturnVolunteeringOpportunitieInformation(){
        
        TestVolunteeringOpportunities test = new TestVolunteeringOpportunities();
        
        String information =  test.Opportunities.returnVolunteeringOpportunitieInformation("Fcit", "Technical", "support");

        String[] spilted = information.split(" ");
        String name = spilted[1];
        
        assertEquals("support",name);
        
    }
    
    
    

    
}
