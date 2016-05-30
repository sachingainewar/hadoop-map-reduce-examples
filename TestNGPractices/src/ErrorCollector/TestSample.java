package ErrorCollector;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSample extends HandlingMutipleErrorinSingleTC{
    
    @Test
    public void one() {
          assertEquals("Comparing 1 and 2", 1, 2);
          assertEquals("Comparing A and B", "A", "B");
          assertEquals("Comparing 10.2 and 10.2", 10.2, 10.2);
    }
   
    @Test
    public void two() {
          setFatal(false);
          assertEquals("Comparing 1 and 2", 1, 2);
          assertEquals("Comparing A and B", "A", "B");
          assertEquals("Comparing 10.2 and 10.2", 10.2, 10.2);
    }

	private void setFatal(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
