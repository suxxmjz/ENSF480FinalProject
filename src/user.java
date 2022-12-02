import java.util.ArrayList;
import java.util.List;


public class User{
    private String firstName;
    private String lastName;
    private String userAddress;
    private String userEmail;
    private String password;
    private int cardNumber;
    private boolean is_registred;

    public User (string firstName, string lastName, string userAddress, string userEmail, string password, int cardNumber, boolean is_registered){
       this.firstName = firstName;
       this.lastName = lastName;
       this.userAddress = userAddress;
       this.userEmail = userEmail;
       this.password = password;
       this.cardNumber = cardNumber;

    }

    public String getFirstName(){
        return firstName;
    }

    
    public String getLastName(){
        return lastName;
    }

    public String getUserAddress(){
        return userAddress;
    }

    public String getuserEmail(){
        return userEmail;
    }

    public String getPassword(){
        return password;
    }

    public String getcardNumber(){
        return cardNumber;
    }

    public boolean is_registered(){
        return this.is_registred;
    }
}
