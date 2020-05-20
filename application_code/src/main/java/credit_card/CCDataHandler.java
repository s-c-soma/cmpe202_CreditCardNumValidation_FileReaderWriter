package credit_card;

public abstract class CCDataHandler {
    
    private CCDataHandler successor = null;

    //abstract method: getCC() 
    public abstract CreditCard getCC();

    public void setSuccessor(CCDataHandler next) {
        this.successor = next;
    }

    public InputData verifyCC(InputData inputrow) {
        return null;
    }

}