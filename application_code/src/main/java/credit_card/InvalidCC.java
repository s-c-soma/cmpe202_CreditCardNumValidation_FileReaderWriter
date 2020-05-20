package credit_card;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InvalidCC extends CCDataHandler {
    private CCDataHandler successor = null;

    public  CreditCard getCC(){
        
        return null;
    }

    public void setSuccessor(CCDataHandler next) {
        this.successor = next;
    }

    public InputData verifyCC(InputData inputrow) {
        

        //Credit card numbers cannot exceed 19 digits; 

        Pattern pattern = Pattern.compile("[a-zA-Z]*"); //special character and character check
        //Matcher match = pattern.matcher(inputrow.getCardNumbere());
        //boolean b = m.find();
        
        //if((inputrow.getCardNumbere().length() > 19 || inputrow.getCardNumbere().length() <= 0) || pattern.matcher(inputrow.getCardNumbere()).find())
       // if((inputrow.getCardNumbere().length() > 19 || inputrow.getCardNumbere().length() <= 0) || inputrow.getCardNumbere().matches("[A-Za-z]+"))
       if((inputrow.getCardNumbere().length() > 19 || inputrow.getCardNumbere().length() <= 0) || !inputrow.getCardNumbere().matches("[0-9]+"))
       {
            inputrow.setCardType("Invalid");
            inputrow.setError("Error");
        }
        else {
            if(this.successor != null) {
                successor.verifyCC(inputrow);
            }
        }
        
        
        return inputrow;
    }
}