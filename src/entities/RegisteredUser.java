package entities;

public class RegisteredUser extends User {

    public RegisteredUser(String firstName, String lastName, String userAddress, String userEmail, String password,
            int cardNumber, boolean is_registered) {
        super(firstName, lastName, userAddress, userEmail, password, cardNumber, is_registered);
    }
 
}
