package credit_card;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class InputData {
    private String CardNumber;
    private String ExpirationDate;
    private String NameOfCardholder;
    private String CardType;
    private String Error; 
    private Date ExpDate;

    public InputData(String CardNumber,String ExpirationDate,String NameOfCardholder){

        this.CardNumber = CardNumber;
        this.ExpirationDate =ExpirationDate;
        this.NameOfCardholder = NameOfCardholder;
        this.CardType = null;
        this.Error = null;
    }

    public InputData(String CardNumber,String ExpirationDate,String NameOfCardholder, String CardType, String Error){

        this.CardNumber = CardNumber;
        this.ExpirationDate =ExpirationDate;
        this.NameOfCardholder = NameOfCardholder;
        this.CardType = CardType;
        this.Error = Error;
    }

    public String getCardNumbere() {
        return this.CardNumber;
    }

    public Long getLongCardNumbere() {
        return Long.parseLong( this.CardNumber ); 
    }

    public String getExpirationDate() {
        return this.ExpirationDate;
    }

    //not being used- for future reference
    public Date getDateExpirationDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String dateInString = "6/20/2030";
        try {
            Date date = formatter.parse(this.ExpirationDate);
            //System.out.println(date);
            System.out.println(formatter.format(date));
            return date;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ExpDate;
    }


    public String getNameOfCardholder() {
        return this.NameOfCardholder;
    }

    public String getCardType() {
        return this.CardType;
    }

    public void setCardType(String CardType) {
         this.CardType = CardType;
    }

    public String getError() {
        return this.Error;
    }

    public void setError(String Error) {
        this.Error = Error;
   }

    @Override
    public String toString() {
        return "CSV:  [CardNumber=" + this.CardNumber + ", ExpirationDate=" + this.ExpirationDate
                + ", NameOfCardholder=" + this.NameOfCardholder 
                + ", CardType=" + this.CardType
                + ", Error=" + this.Error +"]";
    }
}

