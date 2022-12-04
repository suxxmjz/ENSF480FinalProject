package entities;
import java.time.LocalDateTime;
import java.time.Duration;
import controllers.DatabaseController;
import java.util.*;

public class Showtime {
	   private String showroom_ID;
	   private String theatre_name;
	   private String movie_name;
	   private LocalDateTime showing_time;
	   
	   public Showtime(String ID, String tName, String mName, LocalDateTime start) {
		   this.showroom_ID = ID;
		   this.theatre_name = tName;
		   this.movie_name = mName;
		   this.showing_time = start;
		   
	   }
	   
	   public void setShowRoom(String ID) {
		   this.showroom_ID = ID;
	   }
	   
	   public void setTheatre(String name) {
		   this.theatre_name = name;
	   }
	   
	   public void setMovie(String name) {
		   this.movie_name = name;
	   }
	   
	   public void setshowing(LocalDateTime start) {
		   this.showing_time = start;
	   }
	   
	   public String getShowRoom() {
		   return this.showroom_ID;
	   }
	   
	   public String getTheatre() {
		   return this.theatre_name;
	   }
	   
	   public String getMovie() {
		   return this.movie_name;
	   }
	   
	   public LocalDateTime getShowingTime() {
		   return this.showing_time;
	   }
	   
	   public boolean Check72Hours() {
		   Duration duration = Duration.between(LocalDateTime.now(), showing_time);
		   if(duration.toHours() >= 72)
			   return true;
		   else
			   return false;
	   }
	   
	   boolean getSeatStatus(DatabaseController DB, int SeatNum) {
		   ArrayList<Seat> temp = DB.getAvailableSeats(this);
		   for(Seat i : temp) {
			   if (i.getseatNumber() == SeatNum) {
				   return true;
			   		}
			   }
//		   }
			   return false;
	   }
}
