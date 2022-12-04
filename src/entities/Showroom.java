package entities;

public class Showroom {
	public  String dbURL;
	public  String username;
	public  String password;
   

   
   private String showroom_ID;
   private String theatre_name;
   
   public Showroom(String ID, String Name) { //ctor for showroom
	   this.showroom_ID = ID;
	   this.theatre_name = Name;
   }
   
   public void setShowRoom(String ID) { //setter for showroom
	   this.showroom_ID = ID;
   }
   
   public void settheatre(String name) { //setter for theatre
	   this.theatre_name = name;
   }
   
   public String getShowRoom() { //getter for showroom
	   return this.showroom_ID;
   }
   
   public String getTheatre() { //getter for theatre
	   return this.theatre_name;
   }
}
