package credit_card;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;



public class XmlFileHandler extends FileOrganizer {

    public  List<InputData> readFile(String fileName) {

        try {
                List<InputData> creditCardList = new ArrayList<InputData>();
                File fXmlFile = new File(fileName);
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);
                        
                
                doc.getDocumentElement().normalize();
                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
                        
                
                //System.out.println("First Name : " + doc.getElementsByTagName("table:table-cell").item(0).getTextContent());
                NodeList nList = doc.getElementsByTagName("row");
                //System.out.println(nList.getLength());
                
                //System.out.println("----------------------------");
                for (int temp = 0; temp < nList.getLength(); temp++) {

                    Node nNode = nList.item(temp);
                            
                    //System.out.println("\nCurrent Element :" + nNode.getNodeName());
                            
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            
                        Element eElement = (Element) nNode;
            
                        
                        //System.out.println("CardNumber : " + eElement.getElementsByTagName("CardNumber").item(0).getTextContent());
                        //System.out.println("ExpirationDate : " + eElement.getElementsByTagName("ExpirationDate").item(0).getTextContent());
                        //System.out.println("NameOfCardholder : " + eElement.getElementsByTagName("NameOfCardholder").item(0).getTextContent());
                        InputData inputRow;
                        String date= eElement.getElementsByTagName("ExpirationDate").item(0).getTextContent().trim();
                        //checking for valid date format
                        if(super.isValidDate(date)) {
                            inputRow = new InputData(eElement.getElementsByTagName("CardNumber").item(0).getTextContent().trim(), 
                                                     date, 
                                                     eElement.getElementsByTagName("NameOfCardholder").item(0).getTextContent().trim());
                        }
                        else {
                            System.out.println(date +" -Date format not supported");
                            date = "Unsupported Date Format";
                            inputRow = new InputData(eElement.getElementsByTagName("CardNumber").item(0).getTextContent().trim(), 
                                                     date, 
                                                     eElement.getElementsByTagName("NameOfCardholder").item(0).getTextContent().trim());
                        }
                        creditCardList.add(inputRow);
                    }
                }
            return creditCardList;
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
   }

   public  void writeFile(String fileName, List<InputData> creditCardList) {
   
        DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder;
        try {
            icBuilder = icFactory.newDocumentBuilder();
            Document doc = icBuilder.newDocument();
            Element mainRootElement = doc.createElementNS("", "root");
            doc.appendChild(mainRootElement);
 
            // append child elements to root element
            for( InputData inputRow : creditCardList ) {
                System.out.println(inputRow.toString());
    
                // scs-fix later
                mainRootElement.appendChild(getCompany(doc, inputRow.getCardNumbere(), 
                                            inputRow.getCardType(), 
                                            inputRow.getError()));
            }
 
            // output DOM XML to console 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
            DOMSource source = new DOMSource(doc);
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File(fileName));
            //transformer.transform(source, console); // to write to the console 
            transformer.transform(source, file); 
            //System.out.println("\nXML DOM Created Successfully..");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
   } 

    private static Node getCompany(Document doc,  String name, String age, String role) {
        Element company = doc.createElement("row");
        company.appendChild(getCompanyElements(doc, company, "CardNumber", name));
        company.appendChild(getCompanyElements(doc, company, "CardType", age));
        company.appendChild(getCompanyElements(doc, company, "Error", role));
        return company;
    }

    // utility method to create text node
    private static Node getCompanyElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

}
