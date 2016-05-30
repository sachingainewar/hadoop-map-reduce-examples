package ErrorCollector;

import junit.framework.Assert;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;

public class HandlingMutipleErrorinSingleTC {
	public class TestBase {

	      @Rule
	      public ErrorCollector collector = new ErrorCollector();
	     
	      private boolean fatal;
	     
	      public TestBase() {
	            fatal=true;
	      }
	     
	      public void assertEquals(String msg, Object expected, Object actual) {
	            if(getFatal()) {
	                  Assert.assertEquals(msg,expected, actual);
	            } else {
	                  collector.checkThat(msg, actual, CoreMatchers.equalTo(expected));
	            }
	      }
	     
	      public void setFatal(boolean fatalFlag) {
	            fatal = fatalFlag;
	      }
	     
	      public boolean getFatal() {
	            return fatal;
	      }
	     
	}
}
