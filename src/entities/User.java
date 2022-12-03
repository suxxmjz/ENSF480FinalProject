package entities;

import java.util.*;


public class User{
    private String firstName;
    private String lastName;
    private String userAddress;
    private String userEmail;
    private String password;
    private int cardNumber;
    private boolean is_registered;

    public User (String firstName, String lastName, String userAddress, String userEmail, String password, int cardNumber, boolean is_registered){
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

    public int getcardNumber(){
        return cardNumber;
    }

    public boolean is_registered(){
        return this.is_registered;
    }
}
