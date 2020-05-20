package credit_card;

import credit_card.CreditCardApplication;


import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
//import org.junit.Test;

@SpringBootTest
@RunWith(Suite.class)
@SuiteClasses({
				ClientApplicationTests.class,
				FileOrganizerTests.class,
				VerifyCCNumTests.class,
				InputDataTests.class })
public class CreditCardApplicationTests {
	

	@Test
	void contextLoads() {
	}

	@BeforeClass
    public static void beforeClass() {
		
    }
 
    @Before
    public void before() {
       
    }
	
    @After
    public void after() {
    }
 
    @AfterClass
    public static void afterClass() {
	}
	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(CreditCardApplicationTests.class);
		  
		for (Failure failure : result.getFailures()) {
		   System.out.println(failure.toString());
		}
		System.out.println("Test successful? " + result.wasSuccessful());
		
	 }

}
