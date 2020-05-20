package credit_card;

public class VerifyMasterCC extends CCDataHandler{

    private CCDataHandler successor = null;

    public  CreditCard getCC(){
        
        CreditCard cc = new MasterCC();
        return null;
    }

    public void setSuccessor(CCDataHandler next) {
        this.successor = next;
    }

    public InputData verifyCC(InputData inputrow) {

        // First digit is a 5, second digit is in range 1 through 5 inclusive. Only valid length of number is 16 digits.
       // System.out.println(inputrow.getCardNumbere());
        String firstDigit = inputrow.getCardNumbere().substring(0,1);
        if(firstDigit.equals("5")  && inputrow.getCardNumbere().length() == 16)
        {
            int i = Integer.parseInt(inputrow.getCardNumbere().substring(1,2));
            if(i >= 1 && i <= 5) {
                inputrow.setCardType("MasterCard");
                inputrow.setError("None");

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