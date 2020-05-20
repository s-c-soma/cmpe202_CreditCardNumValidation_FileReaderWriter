package credit_card;

public class VerifyAmExCC extends CCDataHandler{

    private CCDataHandler successor = null;

    public  CreditCard getCC(){
        
        CreditCard cc = new AmExCC();
        return null;
    }

    public void setSuccessor(CCDataHandler next) {
        this.successor = next;
    }

    public InputData verifyCC(InputData inputrow) {

        // First digit is a 3 and second digit a 4 or 7. Length is 15 digits.
        //System.out.println(inputrow.getCardNumbere());
        if( inputrow.getCardNumbere().length() == 15 && inputrow.getCardNumbere().substring(0,1).equals("3"))
        {
            String secDigit = inputrow.getCardNumbere().substring(1,2);
            if(secDigit.equals("4")  || secDigit.equals("7")) {
                inputrow.setCardType("AmericanExpress");
                inputrow.setError("None");

                //create CreditCard obj - AmEx
                getCC();
            }
            else {
                if(this.successor != null) {
                    successor.verifyCC(inputrow);
                }
            }
            
        }
        else {
            if(this.successor != null) {
                successor.verifyCC(inputrow);
            }
        }

        return inputrow;
    }

}