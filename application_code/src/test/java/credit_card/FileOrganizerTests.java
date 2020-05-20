package credit_card;
import credit_card.FileOrganizer;

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

public class FileOrganizerTests {

    @BeforeClass
    public static void beforeClass() {
		System.out.println("###############################");
        System.out.println("Class: FileOrganizerTests");
    }

    @Test
	public void controllerTest() {
		System.out.println("Test : controllerTest");
		String inFile = "./sample_input_output_files/Sample_test.csv";
		String outFile = "./sample_input_output_files/Out_test.csv";
        String extension = "csv";
		assertTrue("File controller can parse file successfully", FileOrganizer.controller(inFile,outFile,extension));	
    }

   
    @Test
	public void isValidDateTest() {
        //("MM/dd/yyyy", "M/y", "M/d/y", "M-d-y", "MMM-dd","dd-MMM", "dd-MMM-yyyy")
		System.out.println("Test : isValidDateTest");
        assertTrue("Valid Date Type", FileOrganizer.isValidDate("12/01/2020"));
        assertTrue("Valid Date Type", FileOrganizer.isValidDate("02/2020"));
        assertTrue("Valid Date Type", FileOrganizer.isValidDate("1/1/2020"));
        assertTrue("Valid Date Type", FileOrganizer.isValidDate("3-30-2020"));
        assertTrue("Valid Date Type", FileOrganizer.isValidDate("Jan-20"));
        assertTrue("Valid Date Type", FileOrganizer.isValidDate("20-Jan"));
        assertTrue("Valid Date Type", FileOrganizer.isValidDate("12-01-2020"));

        assertFalse("Valid Date Type", FileOrganizer.isValidDate("12-01/2020"));	
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("###############################");
	}

}