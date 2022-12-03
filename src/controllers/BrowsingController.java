package controllers;

import Database.DatabaseController;
import entities.*;
import View.BrowsingGUI;
import java.time.LocalDate;
import java.text.SimpleDateFormat;

import java.awt.Color;
import java.io.*; 
import java.util.*;
public class BrowsingController {

    private BrowsingGUI browser;
	private DatabaseController dbControl; 
	private MovieTheatreApp app;

	public BrowsingController(DatabaseController db, MovieTheatreApp a) {
		dbControl = db;
		app = a;
	}


    public MovieTheatreApp getApp() {
		return app;
	}
	
	public String getMovies () {
		String movieList = "";
		Date date = new Date ();
		ArrayList <Movie> movieNames = dbControl.getAllMovies();
		for (Movie mov : movieNames) {
			if (mov.getAnnouncement().getTime() <= date.getTime())
                movieList += mov.getMovieName() + "\n";
		}
		return movieList;
	}
	
	public String getUnreleased() {
		String movieList = "";
		Date date = new Date ();
		ArrayList <Movie> allMovies = dbControl.getAllMovies();
		for (Movie mov : allMovies) {
			if (mov.getAnnouncement().getTime() > date.getTime())
                movieList += mov.getMovieName() + "\n";
		}
		return movieList;
	}
	
	public void browse(User user) throws Exception {
		String movieList = "";
		if (user.getClass() == User.class) {
			movies = getMovies();
			browser = new BrowsingGUI ("Browse Movies", movies, this, user);
		} 
		else {
			movies = getMovies();
			String notReleasedYet = getUnreleased();
			browser = new BrowsingGUI ("Browse Movies", movies, notReleasedYet, this, user);
		}
	}
	
	public boolean ordinaryBrowse(String name){
		boolean check = true;
		Date movDate = new Date();
		Movie movie = dbControl.findMovie(name);
		if (movie.getAnnouncement().getTime() > movDate.getTime()){
			check = false;
		}
		return check;
	}
	
	public String ordinaryBrowse () {
		String movieList = "";
		ArrayList <Movie> allMovies = dbControl.getAllMovies();
		Date movDate = new Date();
		for (Movie mov : allMovies) {
			if (mov.getAnnouncement().getTime() <= movDate.getTime());
			movieList += mov.getMovieName() + "\n";
		}
		return movieList;
	}

	public void selectMovie(User user) throws Exception{
				Movie movie = dbControl.findMovie(browser.getMovie());
		if (user.getClass() == User.class) {
			if (movie == null || (movie != null && ordinaryBrowse(browser.getMovie()) == false )) {
				browser.dispose();
				browser.displayInvalidMovie();
				browse(user);
				return;
			}
		}
		else if (movie == null) {
			browser.dispose();
			browser.displayInvalidMovie();
			browse(user);
		}
			
		browser.displayShowtimes(getAllShowtimes(movie.getMovieName()), movie.getMovieName());
		
	}

	public String getAllShowtimes (String movieName) {
		ArrayList<Showtime> showTime = dbControl.getAllShowtimes(movieName);
		String movieList = "";
		for (int i = 0; i < showTime.size(); i++) {
			movieList += (i+1) + ": " + showTime.get(i).toString() + "\n";
		}
		return movieList;
	}
	
    public void selectShowTime() throws Exception{
    	
    	boolean check = true;
    	String movieName = browser.getMovie();
		ArrayList<Showtime> allShowTime = dbControl.getAllShowtimes(movieName);
		int index = Integer.parseInt(browser.getShowtime());
		Showtime showtime = allShowTime.get(index-1);
		ArrayList<Seat> seatList = dbControl.getAllSeats(movieName, showtime);
		Movie movie = dbControl.findMovie(movieName);
		Date date = new Date();
		if (movie.getReleaseDate().getTime() > date.getTime()){
			double ifAvailable = 0;
			for (Seat seat: seatList){
				if (seat.available())
                     ifAvailable ++;
			}
			if (ifAvailable / seatList.size() < .9) {
				browsingGUI.displayInvalidSeat();
				browsingGUI.displayShowtimes(getAllShowtimes(movieName), movieName);
				check = false;
			}
		}
		if (check == true) {
			getSeats (movieName, showtime);
			browsingGUI.displaySeats(movieName);
		}
    }
    
    public String getAllSeats (String movieName, Showtime showtime) {
    	String movieList = "";
    	ArrayList<Seat> seatList= databaseController.getAllSeats(movieName, showtime);
    	
    	for (Seat seat : seatList) {
    		if (seat.getseatNumber()%10 == 0)
            movieList += "\n";
    		movieList += seat.getseatNumber() + "\t";
    	}
    	
    	return movieList;
    }
 
    public void getSeats (String movieName, Showtime showtime) {
    	
    	ArrayList<Seat> allSeats= dbControl.getAllSeats(movieName, showtime);
    	
    	for (Seat s : allSeats) {
    		if (s.available() == false)
    			browser.addSeatsToFrame (s.getseatNumber(), new Color (255, 0, 0));
    		else 
    			browser.addSeatsToFrame (s.getseatNumber(), new Color (0, 255, 0));
    	}
    }
	
	public void selectSeat(User user) throws Exception {
		
		String movieName = browser.getMovie();
		ArrayList<Showtime> allShowTime = dbControl.getAllShowtimes(movieName);
		Showtime showtime = allShowTime.get((Integer.parseInt(browser.getShowtime()) - 1));
		ArrayList<Seat> allSeats= dbControl.getAllSeats(movieName, showtime);
		int index = Integer.parseInt(browser.getSeat()); 
		Seat seat = allSeats.get(index-1);
		browser.dispose();
		if (seat != null) {
			Ticket ticket = dbControl.getTicket(movieName, showtime, seat);
            Payment price = dbControl.getPrice(price);
			user.newTicket(ticket);
			browser.displayConfirmation(price.getPrice());
			app.startPayment();
		}		
	}
}

