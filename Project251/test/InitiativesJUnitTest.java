import classes.Initiatives;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class InitiativesJUnitTest {

    ArrayList<String> initiatives = new ArrayList();

    @Before
    public void setUp() throws FileNotFoundException, IOException {

        String initiativeName = "Afforestation initiative";
        String initiativeIdea = "Afforestation in front of building 27";
        int NumOfPeople = 15;
        int cost = 4000;
        String location = "front of building 27";
        String VisionAndGoal = "Make a beautiful view of the eye";
        String str = initiativeName + "-" + initiativeIdea + "-" + NumOfPeople + "-" + cost + "-" + location + "-" + VisionAndGoal;
        initiatives.add(str);
    }

    @After
    public void tearDown() {
        initiatives.clear();
    }
    
    @Test
    public void testInsertInitiatives() throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        String record = "";
        BufferedReader br = new BufferedReader(new FileReader("initiatives.txt"));
        while ((record = br.readLine()) != null) {
            lines.add(record);
        }
        assertEquals(lines, initiatives);
    }
    
    @Test
    public void testPrintInitiative() {
             
    }
    
    @Test
    public void testreturnInitiative() {
        Initiatives i = new Initiatives();
        String initiativeName = "Afforestation initiative";
        assertNotNull(i.returnInitiative(initiativeName));
    }
}
