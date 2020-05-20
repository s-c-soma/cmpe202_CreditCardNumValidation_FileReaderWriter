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

public class ClientApplicationTests {
    CreditCardApplication client = new CreditCardApplication();

    @BeforeClass
    public static void beforeClass() {
		System.out.println("###############################");
        System.out.println("Class: ClientApplicationTests");
    }

    @Test
    public void CSVFileExtensionTest() {
		System.out.println("Test : CSVFileExtensionTest");
		String fileName = "./sample_input_output_files/Sample_test.csv";
		String  fileType = client.getFileExtension(fileName);
        assertEquals("csv", fileType);
	}
	
	@Test
    public void JSONFileExtensionTest() {
		System.out.println("Test : JSONFileExtensionTest");
		String fileName = "./sample_input_output_files/Sample_test.json";
		String  fileType = client.getFileExtension(fileName);
        assertEquals("json", fileType);
	}
	
	@Test
    public void XMLFileExtensionTest() {
		System.out.println("Test : XMLFileExtensionTest");
		String fileName = "./sample_input_output_files/Sample_test.xml";
		String  fileType = client.getFileExtension(fileName);
        assertEquals("xml", fileType);
    }
	
	@Test
    public void InvalidFileExtensionTest() {
		System.out.println("Test : InvalidFileExtensionTest");
		String fileName = "./sample_input_output_files/Sample.tar";
		CreditCardApplication client = new CreditCardApplication();
		String  fileType = client.getFileExtension(fileName);
        assertNotEquals("New or invalid file type", fileType);
	}

	
	// @Test
    // public void isFileExistTest() {
	// 	System.out.println("Test : isFileExistTest");
	// 	String fileName = "./sample_input_output_files/Sample.csv";
    //     assertTrue("File exist", client.isFileExist(fileName));
	// }

	
	@Test
	public void isSameInOutFileExtTest() {
		System.out.println("Test : isSameInOutFileExtTest");
		String inFile = "./sample_input_output_files/Sample_test.csv";
		String outFile = "./sample_input_output_files/Out_test.csv";
		String outFile1 = "./sample_input_output_files/Out_test.json";
		assertTrue("Input-Output File type mathcing", client.isSameInOutFileExt( inFile, outFile));
		assertFalse("Input-Output File type not mathcing", client.isSameInOutFileExt( inFile, outFile1));
    }
    
    @AfterClass
    public static void afterClass() {
        System.out.println("###############################");
	}

}