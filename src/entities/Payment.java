package entities;
public class Payment {
    private int ticketID;
    private float price;
    private String email;
    private int cardNumber;
    private boolean refunded;

    
   //constructor
    public Payment(int ticketID, float price, String email, int cardNumber, boolean refunded){
        this.ticketID = ticketID;
        this.price = price;
        this.email = email;
        this.cardNumber = cardNumber;
        this.refunded = refunded;

    }

    //getter for payment ID
    public int getID(){
        return ticketID;
    }
    
    //getter for movie price
    public float getPrice(){
        return price;
    }
     
    //getter for email
    public String getEmail(){
        return email;
    }
    
    //getter for user's card number
    public int getCardNumber(){
        return cardNumber;
    }
    
    
    //a boolean flag to check if the amount has been refunded when user cancels
    public boolean checkRefunded(){
        return refunded;
    }


}
