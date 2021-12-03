

import classes.DealingWithFile;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestDealingWithFile {
    
    ArrayList <String> arrayList = new ArrayList <>();
    DealingWithFile dealingWithFile =  new DealingWithFile();
    
    public TestDealingWithFile() {
    }
   
    
     @Before
    public void setUp() {
        arrayList.add("educational CPIT210 3 5 Nov20 Nov30");
    }
    
    @Test
    public void TestReadFile(){
        ArrayList <String> newArrayList= dealingWithFile.readFile("Fcit educational opportunites.txt");
        assertEquals(arrayList.size() , newArrayList.size());
    }
    
   //saveFile(String filename, ArrayList<String> volunteeringOpportunities)
     @Test
    public void TesSaveFile(){
        dealingWithFile.saveFile("test.txt", arrayList);
        
        assertNotNull(dealingWithFile.readFile("test.txt"));
        
    }
}
