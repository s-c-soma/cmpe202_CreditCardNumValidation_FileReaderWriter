package credit_card;

import credit_card.InputData;

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

public class InputDataTests {

    @BeforeClass
    public static void beforeClass() {
		System.out.println("###############################");
        System.out.println("Class: InputDataTests");
    }

    @Test
    public void getLongCardNumbereTest() {
		InputData inputRow = new InputData("4100000000000000","6/20/2030","Richard");
        Long val = inputRow.getLongCardNumbere() ;
        assertEquals(4100000000000000L,4100000000000000L);
    }
    
    @AfterClass
    public static void afterClass() {
        System.out.println("###############################");
	}
}