package controllers;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.sql.Date;

import entities.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DatabaseController {
	private  String dbURL;
	private  String username;
	private  String password;
   
   private Connection dbConnect;
   private PreparedStatement stmt;
   private ResultSet results;
   
   public DatabaseController(String url, String user, String pw) {
	   this.dbURL = url;

       //  Database credentials
       this.username = user;
       this.password = pw;
       
       try{
           dbConnect = DriverManager.getConnection(this.dbURL, this.username, this.password);
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
   
   public DatabaseController() {
	   this.dbURL = "jdbc:mysql://localhost/480_final_project";

       //  Database credentials
       this.username = "root";
       this.password = "password1234";
       
       try{
           dbConnect = DriverManager.getConnection(this.dbURL, this.username, this.password);
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
   
   public ArrayList<Movie> getAllMovies(){
	   ArrayList<Movie> List = new ArrayList<Movie>();
	   String title = "";
	   String genre = "";
	   int runtime;
	   Date typeConverter;
	   LocalDate announcement;
	   String query = "SELECT * FROM 480_final_project.movies";
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   results = stmt.executeQuery();
		   while(results.next()) {
			   title = results.getString("MovieTitle");
			   genre = results.getString("Genre");
			   runtime = results.getInt("RunTime");
			   typeConverter = results.getDate("Announcement");
			   announcement = typeConverter.toLocalDate();
			   List.add(new Movie(title, genre, runtime, announcement));
		   }
		   stmt.close();
		   results.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
	   return List;
   }
   
   public Movie getMovie(String M){
	   String title = "";
	   String genre = "";
	   int runtime;
	   Date typeConverter;
	   LocalDate announcement;
	   Movie returnObj = null;
	   String query = "SELECT * FROM 480_final_project.movies WHERE MovieTitle = ?";
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setString(1, M);
		   results = stmt.executeQuery();
		   while(results.next()) {
			   title = results.getString("MovieTitle");
			   genre = results.getString("Genre");
			   runtime = results.getInt("RunTime");
			   typeConverter = results.getDate("Announcement");
			   announcement = typeConverter.toLocalDate();
			   returnObj = new Movie(title, genre, runtime, announcement);
		   }
		   stmt.close();
		   results.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
	   return returnObj;
   }
   
   public ArrayList<Showtime> getAllShowtimes(String Movie){
	   ArrayList<Showtime> List = new ArrayList<Showtime>();
	   String query = "SELECT * FROM 480_final_project.showtime WHERE movie_name=?";
	   String ID;
	   String theatre;
	   LocalDateTime showingTime;
	   
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setString(1, Movie);
		   results = stmt.executeQuery();
		   while(results.next()) {
			   ID = results.getString("showroom_ID");
			   theatre = results.getString("theatre_name");
			   showingTime = results.getTimestamp("showing_time").toLocalDateTime();
			   List.add(new Showtime(ID, theatre, Movie , showingTime));
		   }
		   stmt.close();
		   results.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
	   return List;
   }
   
   public ArrayList<Showroom> getAllShowrooms(){
	   ArrayList<Showroom> List = new ArrayList<Showroom>();
	   String query = "SELECT * FROM 480_final_project.showroom";
	   String ID;
	   String theatre;
	   
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   results = stmt.executeQuery();
		   while(results.next()) {
			   ID = results.getString("showroom_ID");
			   theatre = results.getString("theatre_name");
			   List.add(new Showroom(ID, theatre));
		   }
		   stmt.close();
		   results.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
	   return List;
   }
   
   public ArrayList<Seat> getAllSeats(Showtime time){
	   ArrayList<Seat> List = new ArrayList<Seat>();
	   String query = "SELECT * FROM 480_final_project.seats WHERE Showtime = ? AND Movie = ? AND ShowRoom = ?";
	   int seatNum;
	   boolean available;
	   
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setTimestamp(1, Timestamp.valueOf(time.getShowingTime()));
		   stmt.setString(2, time.getMovie());
		   stmt.setString(3, time.getShowRoom());
		   results = stmt.executeQuery();
		   while(results.next()) {
			   seatNum = results.getInt("SeatNumber");
			   available = results.getBoolean("Available");
			   List.add(new Seat(seatNum, available, time.getMovie(), time.getShowingTime(), time.getShowRoom()));
		   }
		   stmt.close();
		   results.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
	   return List;
   }
   
   public ArrayList<Seat> getAvailableSeats(Showtime time){
	   ArrayList<Seat> List = new ArrayList<Seat>();
	   String query = "SELECT * FROM 480_final_project.seats WHERE Showtime = ? AND Movie = ? AND ShowRoom = ?";
	   int seatNum;
	   boolean available;
	   
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setTimestamp(1, Timestamp.valueOf(time.getShowingTime()));
		   stmt.setString(2, time.getMovie());
		   stmt.setString(3, time.getShowRoom());
		   results = stmt.executeQuery();
		   while(results.next()) {
			   seatNum = results.getInt("SeatNumber");
			   available = results.getBoolean("Available");
			   if(available)
				   List.add(new Seat(seatNum, available, time.getMovie(), time.getShowingTime(), time.getShowRoom()));
		   }
		   stmt.close();
		   results.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
	   return List;
   }
   
   public ArrayList<Seat> getBookedSeats(Showtime time){
	   ArrayList<Seat> List = new ArrayList<Seat>();
	   String query = "SELECT * FROM 480_final_project.seats WHERE Showtime = ? AND Movie = ? AND ShowRoom = ?";
	   int seatNum;
	   boolean available;
	   
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setTimestamp(1, Timestamp.valueOf(time.getShowingTime()));
		   stmt.setString(2, time.getMovie());
		   stmt.setString(3, time.getShowRoom());
		   results = stmt.executeQuery();
		   while(results.next()) {
			   seatNum = results.getInt("SeatNumber");
			   available = results.getBoolean("Available");
			   if(!available)
				   List.add(new Seat(seatNum, available, time.getMovie(), time.getShowingTime(), time.getShowRoom()));
		   }
		   stmt.close();
		   results.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
	   return List;
   }
   
   public void updateSeat(Showtime time, int ID) {
	   String query = "UPDATE 480_final_project.seats SET Available=?  WHERE Showtime = ? AND Movie = ? AND ShowRoom = ?";
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setInt(1, ID);
		   stmt.setTimestamp(2, Timestamp.valueOf(time.getShowingTime()));
		   stmt.setString(3, time.getMovie());
		   stmt.setString(4, time.getShowRoom());
		   stmt.executeUpdate();
		   
		   stmt.close();
//		   results.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
   }
   
   public void addUser(User user) {
	   String query = "INSERT INTO `480_final_project`.`users` VALUES(?,?,?,?,?,?, 0)";
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setString(1, user.getFirstName());
		   stmt.setString(2, user.getLastName());
		   stmt.setString(3, user.getUserAddress());
		   stmt.setInt(4, user.getcardNumber());
		   stmt.setString(5, user.getuserEmail());
		   stmt.setString(6, user.getPassword());
		   stmt.executeUpdate();
		   stmt.close();
//		   results.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
   }
   
   public void addRegisteredUser(RegisteredUser user) {
	   String query = "INSERT INTO `480_final_project`.`users` VALUES(?,?,?,?,?,?, 1)";
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setString(1, user.getFirstName());
		   stmt.setString(2, user.getLastName());
		   stmt.setString(3, user.getUserAddress());
		   stmt.setInt(4, user.getcardNumber());
		   stmt.setString(5, user.getuserEmail());
		   stmt.setString(6, user.getPassword());
		   stmt.executeUpdate();
		   stmt.close();
//		   results.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
   }
   
   public User getUser(String username, String password) {
	   String query = "SELECT * FROM 480_final_project.users WHERE Email =? AND Password = ?";
	   User returnObj = null;
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setString(1, username);
		   stmt.setString(2, password);
		   results = stmt.executeQuery();
		   if(results.next()) {
			    String firstName = results.getString("Firstname");
				String lastName = results.getString("Lastname");
				String userAddress = results.getString("UserAddress");
				int cardNumber = results.getInt("CardNumber");
			   returnObj = new User(firstName, lastName, userAddress, username, password, cardNumber);
		   }
		   stmt.close();
		   results.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
	   return returnObj;
   }
   
   public RegisteredUser getRegisteredUser(String username, String password) {
	   String query = "SELECT * FROM 480_final_project.users WHERE Email =? AND Password = ?";
	   RegisteredUser returnObj = null;
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setString(1, username);
		   stmt.setString(2, password);
		   results = stmt.executeQuery();
		   if(results.next()) {
			   if(results.getBoolean("is_registered")) {
				   String firstName = results.getString("Firstname");
					String lastName = results.getString("Lastname");
					String userAddress = results.getString("UserAddress");
					int cardNumber = results.getInt("CardNumber");
				   returnObj = new RegisteredUser(firstName, lastName, userAddress, username, password, cardNumber);
			   }
		   }
		   stmt.close();
		   results.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
	   return returnObj;
   }
   
   public boolean checkRegisterStatus(String email) {
	   String query = "SELECT * FROM 480_final_project.users WHERE Email =?";
	   boolean result = false;
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setString(1, email);
		   results = stmt.executeQuery();
		   if(results.next()) {
			    result = results.getBoolean("is_registered");
		   }
		   stmt.close();
		   results.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
	   return result;
   }
   
   public static void main(String[] args) throws SQLException {
	   DatabaseController test = new DatabaseController();
	   RegisteredUser i = new RegisteredUser("john", "doe", "place","johnRU@email.com" , "1234", 987654321);
	   test.addRegisteredUser(i);
   
   }
}