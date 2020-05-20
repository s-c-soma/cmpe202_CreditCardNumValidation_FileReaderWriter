package credit_card;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 

public class CsvFileHandler extends FileOrganizer {
     
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static String NEW_LINE_SEPARATOR = "\n";

    //Credit card attributes index
    private static final int CC_NUMBER_IDX = 0;
    private static final int CC_EXP_DATE_IDX = 1;
    private static final int CC_HOLDER_NAME = 2;
  
    
    
   
     
    public  List<InputData> readFile(String fileName) {
 
        BufferedReader fileReader = null;
        try {
            //Create a new list of credit card to be filled by CSV file data 
            List<InputData> creditCardList = new ArrayList<InputData>();
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));
            //Read the CSV file header to skip it
            while((line = fileReader.readLine()).length() == 0) {
                continue;
            }
        
            /*file check conditions:
                to check blank lines :tokens.length != 1
                to check blank line before header
            */
            //Read the file line by line starting from the second line
            
                //fileReader.readLine();
                while ((line = fileReader.readLine()) != null && line != "") {
                    //Get all tokens available in line
                    //System.out.println(line);
                    String[] tokens = line.split(COMMA_DELIMITER);
                    if (tokens.length > 0 && tokens.length != 1) {
                        //System.out.println("token:");
                        //System.out.println(tokens.toString());
    
                        //Create a new student object and fill his  data
                        InputData inputRow;
                        if(super.isValidDate(tokens[CC_EXP_DATE_IDX])) {
                            inputRow = new InputData(tokens[CC_NUMBER_IDX], tokens[CC_EXP_DATE_IDX], tokens[CC_HOLDER_NAME]);
                        }
                        else {
                            System.out.println(tokens[CC_EXP_DATE_IDX] +" -Date format not supported");
                            inputRow = new InputData(tokens[CC_NUMBER_IDX], "Unsupported Date Format", tokens[CC_HOLDER_NAME]);
                        }
                        creditCardList.add(inputRow);
                        //System.out.println(inputRow.getCardNumbere() + '\n' + inputRow.getExpirationDate() + '\n'+ inputRow.getNameOfCardholder());
    
                    }
                }
            //print object values
            /*
            for(int i=0; i < creditCardList.size(); i++){
                System.out.println( creditCardList.get(i).toString() );
            }

            System.out.println("Print Arraylist using for each loop");
            for( InputData inputRow : creditCardList ){
                System.out.println(inputRow.toString());
            }
            */
            return creditCardList;
        }  catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return null;
    }

    public void writeFile(String fileName, List<InputData> creditCardList) {
        //CSV file header
         String FILE_HEADER = "CardNumber,CardType,Error";
        FileWriter fileWriter = null;       
        try {
                fileWriter = new FileWriter(fileName);
     
                //Write the CSV file header
                fileWriter.append(FILE_HEADER.toString());
                 
                //Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);
                 
                //Write a new  object list to the CSV file
                for( InputData inputRow : creditCardList ){
                    System.out.println(inputRow.toString());
                    fileWriter.append(inputRow.getCardNumbere());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(inputRow.getCardType());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(inputRow.getError());
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }
                System.out.println("CSV file was created successfully !!!");    
        } catch (Exception e) {
                System.out.println("Error in CsvFileWriter !!!");
                e.printStackTrace();
        } finally {  
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
                }   
        }
    }
 
}