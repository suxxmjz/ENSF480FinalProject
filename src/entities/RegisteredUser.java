package entities;
import java.util.*;

public class RegisteredUser extends User {
            private Information information;
            private ArrayList<Movie> movies;
 
            public RegisteredUser() {
                information = null;
            }

            public Information getInformation(){
                return information;
            }
}
