package credit_card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class FileOrganizer {

    //abstract methods
    public abstract List<InputData> readFile(String fileName);
    public abstract void writeFile(String fileName, List<InputData> creditCardList);

    public FileOrganizer() {}
     
    public static Boolean controller(String inputFile, String outputFile, String extension) {
        List<InputData> creditCardList = new ArrayList<InputData>();

        if(extension.equals("csv")) {
            System.out.println("\nRead CSV file:");
            creditCardList= new CsvFileHandler().readFile(inputFile);

            creditCardList = ccHandler(creditCardList);
            System.out.println("Write CSV file:");
            new CsvFileHandler().writeFile(outputFile,creditCardList);
            return true;
        }
        else if(extension.equals("json")) {
            System.out.println("\nRead JSON file:");
            creditCardList= new JsonFileHandler().readFile(inputFile);

            creditCardList = ccHandler(creditCardList);
            System.out.println("\nWrite JSON file:");
            new JsonFileHandler().writeFile(outputFile, creditCardList);
            
            // System.out.println("Read Json File");
            // for( InputData inputRow : creditCardList ){
            //     System.out.println(inputRow.toString());
            // }
    
            
            return true;
        }
        else if(extension.equals("xml")) {

            System.out.println("\nRead XML file:");
            creditCardList = new XmlFileHandler().readFile(inputFile);
            
            creditCardList = ccHandler(creditCardList);
            System.out.println("\nWrite Xml file:");
            new XmlFileHandler().writeFile(outputFile, creditCardList);
            return true;
        }
        else  {
            System.out.println("New or invalid file type ");
            return false;
        }
        
    }

    // test case not applicable ; handler method of strategic pattern/chain of responsibility
    public static List<InputData> ccHandler(List<InputData> creditCardList) {
		CCDataHandler cc0 = new InvalidCC();
		CCDataHandler cc1 = new VerifyVisaCC();
		CCDataHandler cc2 = new VerifyMasterCC();
		CCDataHandler cc3 = new VerifyAmExCC();
		CCDataHandler cc4 = new VerifyDiscoverCC();

		//set successor
		cc0.setSuccessor(cc1);
		cc1.setSuccessor(cc2);
		cc2.setSuccessor(cc3);
        cc3.setSuccessor(cc4);
        
        System.out.println("\n"+"----Credit Card Object Creation:-----"+"\n");
        for( InputData inputRow : creditCardList ){
            
            inputRow = cc0.verifyCC(inputRow);
            //System.out.println(inputRow.toString());
        }
        System.out.println("-------------------------------------");
        return creditCardList;
    }

    public static boolean isValidDate(String dateString) {
        // DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        // sdf.setLenient(true);
        // try {
        //     sdf.parse(dateString);
        // } catch (ParseException e) {
        //     return false;
        // }
        // return true;
        //---------------------
        List<String> formatStrings = Arrays.asList("MM/dd/yyyy", "M/y", "M/d/y", "M-d-y", "MMM-dd","dd-MMM", "dd-MMM-yyyy");
        for (String formatString : formatStrings)
        {
            try{
                 new SimpleDateFormat(formatString).parse(dateString);
                 return true;
            }
            catch (ParseException e) {
                
            }
        }
        return false;
    }

    
  

}