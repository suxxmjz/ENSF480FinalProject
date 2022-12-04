
package entities;

import java.time.Duration;
import java.time.LocalDate;


public class Movie {
    private String movieName;
    private String genre;
    private int runTime;
    private LocalDate announcement;

   //constructor
    public Movie (String movieName, String genre, int runTime, LocalDate announcement){
        this.movieName = movieName;
        this.genre = genre;
        this.runTime = runTime;
        this.announcement = announcement;
    }
    
	//getter for movie name
    public String getMovieName() {
        return movieName;
    }
	
   //getter for movie genre
    public String getGenre() {
        return genre;
    }
 
   //getter for movie run time
    public int getRunTime() {
        return runTime;
    }

	//getter for annoucement that uses the local date of the user
    public LocalDate getAnnouncement() {
        return announcement;
    }
      
	//function to give movie annoucements one week before they are publicly released
    public boolean Check1Week() {
		   Duration duration = Duration.between(LocalDate.now(), announcement);
		   if(duration.toDays() <= 7)
			   return true;
		   else
			   return false;
	   }

}
