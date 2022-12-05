package controllers;

import java.sql.*;
import java.util.*;
import java.sql.Date;

import entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
   
   public  Showtime getShowTime(int id) {
	      String query = "SELECT * FROM 480_final_project.showtime WHERE id=?";
	      Showtime returnObj = null;
	      String ID;
	      String theatre;
	      LocalDateTime showingTime;
	      String movie;
	      try {
	          stmt = dbConnect.prepareStatement(query);
	          stmt.setInt(1, id);
	          results = stmt.executeQuery();
	          if(results.next()) {
	        	  ID = results.getString("showroom_ID");
	          theatre = results.getString("theatre_name");
	          showingTime = results.getTimestamp("showing_time").toLocalDateTime();
	          movie = results.getString("movie_name");
	          returnObj = new Showtime(ID, theatre, movie, showingTime);
	          }
	      }catch(Exception e) {
	           System.out.println(e);
	       }
	     return returnObj; 
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
   
   public void changeToBooked(Showtime time, int ID) {
	   String query = "UPDATE 480_final_project.seats SET Available=?  WHERE Showtime = ? AND Movie = ? AND ShowRoom = ? AND SeatNumber=?";
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setInt(1, 0);
		   stmt.setTimestamp(2, Timestamp.valueOf(time.getShowingTime()));
		   stmt.setString(3, time.getMovie());
		   stmt.setString(4, time.getShowRoom());
		   stmt.setInt(5, ID);
		   stmt.executeUpdate();
		   
		   stmt.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
   }
   
   public void changeToAvailable(Showtime time, int ID) {
	   String query = "UPDATE 480_final_project.seats SET Available=?  WHERE Showtime = ? AND Movie = ? AND ShowRoom = ? AND SeatNumber=?";
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setInt(1, 1);
		   stmt.setTimestamp(2, Timestamp.valueOf(time.getShowingTime()));
		   stmt.setString(3, time.getMovie());
		   stmt.setString(4, time.getShowRoom());
		   stmt.setInt(5, ID);
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
	   String firstName = null;
	   String lastName = null;
	   String userAddress = null;
	   int cardNumber = -1;
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setString(1, username);
		   stmt.setString(2, password);
		   results = stmt.executeQuery();
		   if(results.next()) {
			   if(results.getBoolean("is_registered")) {
				    firstName = results.getString("Firstname");
					 lastName = results.getString("Lastname");
					userAddress = results.getString("UserAddress");
					cardNumber = results.getInt("CardNumber");
//				   returnObj = new RegisteredUser(firstName, lastName, userAddress, username, password, cardNumber);
			   }
		   }
		   stmt.close();
		   results.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
	   if(firstName != null)
		   returnObj = new RegisteredUser(firstName, lastName, userAddress, username, password, cardNumber);
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
   
   public Ticket getTicket(int id, String email) {
	   String query = "SELECT * FROM 480_final_project.ticket WHERE id =? AND email = ?";
	   Ticket returnObj = null;
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setInt(1, id);
		   stmt.setString(2, email);
		   results = stmt.executeQuery();
		   if(results.next()) {
			   	 int seat = results.getInt("seatNo");
				   String showroom_ID = results.getString("showroom_ID");
					String movie = results.getString("movieName");
					LocalDateTime showingTime = results.getTimestamp("showing_time").toLocalDateTime();
					LocalDateTime datePurchased = results.getTimestamp("datePurchased").toLocalDateTime();
					LocalDate temp = datePurchased.toLocalDate();
					double price = (double) results.getFloat("price");
					ArrayList<Showtime> x = this.getAllShowtimes(movie);
				   returnObj = new Ticket(id, seat,  showroom_ID,  movie,  x.get(0).getTheatre(), temp ,showingTime, email, price);
			   }
		   stmt.close();
		   results.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
	   return returnObj;
   }
   
   public Voucher getVoucher(int id, String email) {
	   String query = "SELECT * FROM 480_final_project.voucher WHERE code_ =? AND email = ?";
	   Voucher voucherObj = null;
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setInt(1, id);
		   stmt.setString(2, email);
		   results = stmt.executeQuery();
		   if(results.next()) {
			   		LocalDateTime expDate = results.getTimestamp("expiration").toLocalDateTime();
			   	 	int amount = results.getInt("amount");
			   	 	LocalDate temp = expDate.toLocalDate();
					voucherObj = new Voucher(id, amount, temp, email);
			   }
		   stmt.close();
		   results.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
	   return voucherObj;
   }
   
   public void addTicket(Ticket t) {
	   String query = "INSERT INTO `480_final_project`.`ticket` VALUES(?,?,?,?,?,?,?,?)";
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setInt(1, t.getID());
		   stmt.setInt(2, t.getSeatNo());
		   stmt.setString(3, t.getShowtimeObj().getShowRoom());
		   stmt.setString(4, t.getShowtimeObj().getMovie());
		   stmt.setTimestamp(5, Timestamp.valueOf(t.getDatePurchased().atStartOfDay()));
		   stmt.setTimestamp(6, Timestamp.valueOf(t.getShowtimeObj().getShowingTime()));
		   stmt.setString(7, t.getEmail());
		   stmt.setFloat(8, (float) t.getPrice());
		   stmt.executeUpdate();
		   stmt.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
   }
   
   public void addVoucher(Voucher V) {
	   String query = "INSERT INTO `480_final_project`.`voucher` VALUES(?,?,?,?)";
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setInt(1, V.getCode());
		   stmt.setDouble(2, V.getAmount());
		   stmt.setTimestamp(3, Timestamp.valueOf(V.getExpirationDate().atStartOfDay()));
		   stmt.setString(4, V.getEmail());
		   stmt.executeUpdate();
		   stmt.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
   }
   
   public double validateVoucher(Voucher V) {
	   String query = "SELECT * FROM 480_final_project.voucher WHERE code_ = ? AND email =?";
	   double a = -1;
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setInt(1, V.getCode());
		   stmt.setString(2, V.getEmail());
		   results = stmt.executeQuery();
		   
		   if(results.next()) {
			   stmt.close();
//			   Duration duration = Duration.between(LocalDateTime.now(),  results.getTimestamp("expiration").toLocalDateTime());
//			   if (duration.toMinutes() > 0)
//				   return results.getDouble("amount");
			   a = 1;
		   }
		   stmt.close();
		   results.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
	   return a;
   }
   
   public void deleteTicket(Ticket T) {
	   String query = "DELETE FROM 480_final_project.ticket WHERE id =? AND email = ?";
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setInt(1, T.getID());
		   stmt.setString(2, T.getEmail());
		   stmt.executeUpdate();
		   stmt.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
   }
   
   public void deleteVoucher(Voucher V) {
	   String query = "DELETE FROM `480_final_project`.`voucher` WHERE code_ =? AND email = ?";
	   try {
		   stmt = dbConnect.prepareStatement(query);
		   stmt.setInt(1, V.getCode());
		   stmt.setString(2, V.getEmail());
		   stmt.executeUpdate();
		   stmt.close();
	   } catch(Exception e) {
		   System.out.println(e);
	   }
   }
   
   public static void main(String[] args) throws SQLException {
	   DatabaseController test = new DatabaseController();
	   RegisteredUser i = new RegisteredUser("john", "doe", "place","johnRU@email.com" , "1234", 987654321);
	   test.addRegisteredUser(i);
   
   }
}