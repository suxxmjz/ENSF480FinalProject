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
       this.username = "user";
       this.password = "aa";
       
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
   
   public ArrayList<Seats> getAllSeats(Showtime time){
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
   
   public static void main(String[] args) throws SQLException {
	   DatabaseController test = new DatabaseController();
	   Movie i = test.getMovie("movie2");
//	   for(Showroom i : Movie) {
		   System.out.println("Movie is " + i.getMovieName() + " genre is " + i.getGenre()+ " runtime is " + i.getRunTime() + "announcemnt is at : " + i.getAnnouncement());
//	   }
   
   }
}