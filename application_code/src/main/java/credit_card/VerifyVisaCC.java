package credit_card;

public class VerifyVisaCC extends CCDataHandler {

    private CCDataHandler successor = null;

    public  CreditCard getCC(){
        
        CreditCard cc = new VisaCC();
        return null;
    }

    public void setSuccessor(CCDataHandler next) {
        this.successor = next;
    }

    public InputData verifyCC(InputData inputrow) {

        //First digit is a 4. Length is either 13 or 16 digits.
        //System.out.println(inputrow.getCardNumbere());
        String firstDigit = inputrow.getCardNumbere().substring(0,1);
        int length = inputrow.getCardNumbere().length();
        
        if( ( firstDigit.equals("4")  && length == 13) || ( firstDigit.equals("4") && length == 16))
        {
            inputrow.setCardType("Visa");
            inputrow.setError("None");

            getCC();
        }
        else {
            if(this.successor != null) {
                successor.verifyCC(inputrow);
            }
        }

        return inputrow;
    }

}