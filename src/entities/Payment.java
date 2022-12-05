package entities;
public class Payment {
    private int ticketID;
    private float price;
    private String email;
    private int cardNumber;
    private boolean refunded;

    public Payment(int ticketID, float price, String email, int cardNumber, boolean refunded){
        this.ticketID = ticketID;
        this.price = price;
        this.email = email;
        this.cardNumber = cardNumber;
        this.refunded = refunded;

    }

    public int getID(){
        return ticketID;
    }

    public float getPrice(){
        return price;
    }

    public String getEmail(){
        return email;
    }

    public int getCardNumber(){
        return cardNumber;
    }

    public boolean checkRefunded(){
        return refunded;
    }


}
