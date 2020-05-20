package credit_card;

public class VerifyDiscoverCC extends CCDataHandler{

    private CCDataHandler successor = null;

    public  CreditCard getCC(){
        
        CreditCard cc = new DiscoverCC();
        return null;
    }

    public void setSuccessor(CCDataHandler next) {
        this.successor = next;
    }

    public InputData verifyCC(InputData inputrow) {

        // First four digits are 6011. Length is 16 digits..
        //System.out.println(inputrow.getCardNumbere());
        String firstSubStr = null;
        if(inputrow.getCardNumbere().length() >= 4) {
            firstSubStr = inputrow.getCardNumbere().substring(0,4);
        }
        
        if(inputrow.getCardNumbere().length() == 16 && firstSubStr.equals("6011"))
        {
            inputrow.setCardType("Discover");
            inputrow.setError("None");    
            
            getCC();
        }
        else {
            inputrow.setCardType("Invalid");
            inputrow.setError("Error");
        }


        return inputrow;
    }

}