package entities;

public class RegisteredUser extends User {
            //constructor
            public RegisteredUser(String firstName, String lastName, String userAddress, String userEmail, String password, int cardNumber) {
                        //calling super() function with the arguments passed to it to indicate a superclass
                super(firstName, lastName, userAddress, userEmail, password, cardNumber);            
            }  
}