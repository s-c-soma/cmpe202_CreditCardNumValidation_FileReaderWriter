package credit_card;


import credit_card.InvalidCC;
import credit_card.VerifyVisaCC;
import credit_card.VerifyMasterCC;
import credit_card.VerifyAmExCC;
import credit_card.VerifyDiscoverCC;



import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class VerifyCCNumTests {

    //This class verifies all methods from all the chain of command classes that validates CC nums
    
    @BeforeClass
    public static void beforeClass() {
		System.out.println("###############################");
        System.out.println("Class: VerifyCCNumTests");

    }

    @Test
	public void verifyInvalidCCTest() {
        System.out.println("Test : verifyInvalidCCTest");
        InputData inputRow, outputRow;
        InvalidCC cc = new InvalidCC();

        inputRow = new InputData("5100000a000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCC(inputRow);
        assertEquals("Invalid", outputRow.getCardType());	
        
        inputRow = new InputData("qwed","6/20/2030","Richard");
        outputRow = cc.verifyCC(inputRow);
        assertEquals("Invalid", outputRow.getCardType());
        
        
    }

    @Test
	public void verifyVisaCCTest() {
         //Visa CC: First digit is a 4. Length is either 13 or 16 digits.
       
        System.out.println("Test : verifyVisaCCTest ");
        InputData inputRow, outputRow;
        VerifyVisaCC cc = new VerifyVisaCC();

        inputRow = new InputData("4100000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCC(inputRow);
        assertEquals("Visa", outputRow.getCardType());	
        
        inputRow = new InputData("4000000000001","6/20/2030","Richard");
        outputRow = cc.verifyCC(inputRow);
        assertEquals("Visa", outputRow.getCardType());
        
        inputRow = new InputData("4000000000001999","6/20/2030","Richard");
        outputRow = cc.verifyCC(inputRow);
        assertEquals("Visa", outputRow.getCardType());
        assertNotEquals("Invalid", outputRow.getCardType());
    }

    @Test
	public void verifyMasterCCTest() {
         //Master CC: First digit is a 5, second digit is in range 1 through 5 inclusive. Only valid length of number is 16 digits..
        System.out.println("Test : verifyMasterCCTest ");
        InputData inputRow, outputRow;
        VerifyMasterCC cc = new VerifyMasterCC();

        inputRow = new InputData("5100000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCC(inputRow);
        assertEquals("MasterCard", outputRow.getCardType());	
        
        inputRow = new InputData("5200000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCC(inputRow);
        assertEquals("MasterCard", outputRow.getCardType());

        inputRow = new InputData("5300000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCC(inputRow);
        assertEquals("MasterCard", outputRow.getCardType());

        inputRow = new InputData("5400000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCC(inputRow);
        assertEquals("MasterCard", outputRow.getCardType());
        
        inputRow = new InputData("5500000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCC(inputRow);
        assertEquals("MasterCard", outputRow.getCardType());
        assertNotEquals("Invalid", outputRow.getCardType());
    }

    @Test
	public void VerifyAmExCCTest() {
         //AmEX: First digit is a 3 and second digit a 4 or 7. Length is 15 digits.
        System.out.println("Test : VerifyAmExCCTest ");
        InputData inputRow, outputRow;
        VerifyAmExCC cc = new VerifyAmExCC();
        
        inputRow = new InputData("340000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCC(inputRow);
        assertEquals("AmericanExpress", outputRow.getCardType());	

        inputRow = new InputData("370000000000000","6/20/2030","Richard");
        assertEquals("AmericanExpress", outputRow.getCardType());
        assertNotEquals("Invalid", outputRow.getCardType());
    }

    @Test
	public void VerifyDiscoverCCTest() {
         //Discover cc: First four digits are 6011. Length is 16 digits..
        System.out.println("Test : VerifyDiscoverCCTest ");
        InputData inputRow, outputRow;
        VerifyDiscoverCC cc = new VerifyDiscoverCC(); 

        inputRow = new InputData("6011000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCC(inputRow);
        assertEquals("Discover", outputRow.getCardType());	
        
        inputRow = new InputData("601100000000000","6/20/2030","Richard");
        outputRow = cc.verifyCC(inputRow);
        assertNotEquals("Discover", outputRow.getCardType());

        inputRow = new InputData("6110000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCC(inputRow);
        assertNotEquals("Discover", outputRow.getCardType());

        inputRow = new InputData("5400000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCC(inputRow);
        assertNotEquals("Discover", outputRow.getCardType());
        
        inputRow = new InputData("55000sdg000000000","6/20/2030","Richard");
        outputRow = cc.verifyCC(inputRow);
        assertNotEquals("Discover", outputRow.getCardType());
        assertEquals("Invalid", outputRow.getCardType());

        inputRow = new InputData("$%&*","6/20/2030","Richard");
        outputRow = cc.verifyCC(inputRow);
		assertEquals("Invalid", outputRow.getCardType());
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("###############################");
	}


}