package entities;


public class Showroom {
	public  String dbURL;
	public  String username;
	public  String password;
   
   
   private String showroom_ID;
   private String theatre_name;
   
   public Showroom(String ID, String Name) {
	   this.showroom_ID = ID;
	   this.theatre_name = Name;
   }
   
   public void setShowRoom(String ID) {
	   this.showroom_ID = ID;
   }
   
   public void settheatre(String name) {
	   this.theatre_name = name;
   }
   
   public String getShowRoom() {
	   return this.showroom_ID;
   }
   
   public String getTheatre() {
	   return this.theatre_name;
   }
}
