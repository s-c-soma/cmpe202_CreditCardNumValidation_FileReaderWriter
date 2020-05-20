package credit_card;

import org.json.simple.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.TimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;




@SpringBootApplication
public class CreditCardApplication {

    public CreditCardApplication() {}

    public static String getFileExtension(String filename) {
        String fileName = filename;
        final File file = new File(fileName);
        try
        {
            Object fileType = Files.probeContentType(file.toPath());
            
             
            //String fileType = FilenameUtils.getExtension(fileName);
            //System.out.println("fileType: " + fileType);

            String extension = "";

            int i = fileName.lastIndexOf('.');
            if (i > 0) {
                extension = fileName.substring(i+1);
            }
            //System.out.println("fileType: " + extension);
            return extension; 

        }catch (FileNotFoundException ex) {
            System.out.println( fileName + "not found " );
        }
        catch (IOException ioException) {
            System.out.println(
                "ERROR: Unable to determine file type for " + fileName
                    + " due to exception " + ioException);
        }
        return "";
    }

    public static boolean isFileExist(String inputFile) {
        return new File(inputFile).isFile();
    }

    public static boolean isSameInOutFileExt(String inFile, String outFile) {
        String inExt = getFileExtension(inFile);
        System.out.println("Input fileType: " + inExt);
        String outExt = getFileExtension(outFile);
        System.out.println("Output fileType: " + outExt);

        return inExt.equals(outExt);
    }

//./sample_input_output_files/
	public static void main(String[] args) {
        String path    = "./sample_input_output_files/";
        String csvIn   = "./sample_input_output_files/Sample.csv";
        String jsonIn  = "./sample_input_output_files/Sample.json";
        String xmlIn   = "./sample_input_output_files/Sample.xml";
        String csvOut  = "./sample_input_output_files/Out.csv";
        String jsonOut = "./sample_input_output_files/Out.json";
        String xmlOut  = "./sample_input_output_files/Out.xml";
        
        String inputFile = csvIn;
        String outpuFile = csvOut;
        
     
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Please enter input file name [Example: Sample.csv/Sample.json/Sample.xml] : ");
            String in = scanner.next(); // get string

            System.out.println("Please enter output file name [Example: Out.csv/Out.json/Out.xml] : ");
            String out = scanner.next(); // get string
            inputFile = path + in;
            outpuFile = path + out;
            System.out.format("Input file : %s, Output file : %s", inputFile, outpuFile);

            try
            {
                //System.out.println("fileType: " + extension);
                if(isFileExist(inputFile)) {
                    if(isSameInOutFileExt(inputFile,outpuFile) ) {
                        String extension = getFileExtension(inputFile);
                        Boolean get= FileOrganizer.controller(inputFile,outpuFile,extension);
                    }
                    else
                        System.out.println("Input-Output file extensions are not same. Please give same file extension.");
                }
                else
                    System.out.println('\n' +"No such input file exist"+ '\n');
                
            }
            catch (Exception e) {
                System.out.println("Input-Output file extensions are not same. Please give same file extension.");
                e.printStackTrace();
            }
        }
	}
}




































