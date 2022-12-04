package controllers;

import DatabaseController;
import entities.*;
import gui.*;
import java.time.LocalDate;
import java.text.SimpleDateFormat;

import java.awt.*;
import java.io.*; 
import java.util.*;
import javax.swing.*;

public class BrowsingController {

    private MovieGUI browser;
	private DatabaseController dbControl; 
	private MovieTheatreApp app;

	public BrowsingController(DatabaseController db, MovieTheatreApp a) {
		dbControl = db;
		app = a;
	}


    public MovieTheatreApp getApp() {
		return app;
	}
	
	public String getAllMovies () {
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
			movies = getMovie();
			browser = new MovieGUI("Search Movies", movies, this, user);
		} 
		else {
			movies = getMovie();
			String notReleasedYet = getUnreleased();
			browser = new MovieGUI("Search Movies", movies, notReleasedYet, this, user);
		}
	}
	
	public boolean regularUserBrowsing(String movName){
		boolean isRegular = true;
		Date movDate = new Date();
		Movie movie = dbControl.getMovieName(movName);
		if (movie.getAnnouncement().getTime() > movDate.getTime()){
			isRegular = false;
		}
		return isRegular;
	}
	
	public String regularUserBrowsing () {
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
		Movie movies = dbControl.findMovie(browser.getMovie());
		if (user.getClass() == User.class) {
			if (movies == null || (movies != null && regularUserBrowsing(browser.getMovie()) == false )) {
				browser.dispose();
				browser.displayInvalidMovie();
				browse(user);
				return;
			}
		}
		else if (movies == null) {
			browser.dispose();
			browser.displayInvalidMovie();
			browse(user);
		}
			
		browser.displayShowtimes(getAllShowtimes(movies.getMovieName()), movies.getMovieName());
		
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
				seatGUI.displayInvalidSeat();
				seatGUI.displayShowtimes(getAllShowtimes(movieName), movieName);
				check = false;
			}
		}
		if (check == true) {
			getSeats (movieName, showtime);
			seatGUI.displaySeats(movieName);
		}
    }
    
    public void changeSeatColor (int i, Color c) {
		JPanel f = new JPanel();
		f.setPreferredSize(new Dimension(30, 30));
		f.setBackground(c);
		f.add(new JLabel (String.valueOf(i), JLabel.CENTER));
		seats.add(f);
	}
    
    public String getAllSeats (String movieName, Showtime showtime) {
    	String movieList = "";
    	ArrayList<Seat> seatList= dbControl.getAllSeats(movieName, showtime);
    	
    	for (Seat seat : seatList) {
    		if (seat.getseatNumber()%10 == 0)
            movieList += "\n";
    		movieList += seat.getseatNumber() + "\t";
    	}
    	
    	return movieList;
    }
 
    public void getSeats (String movieName, Showtime showtime) {
    	ArrayList<Seat> allSeats= dbControl.getAllSeats(movieName, showtime);
    	for (Seat seat : allSeats) {
    		if (seat.available() == false)
    			browser.changeSeatColor(seat.getseatNumber(), new Color (255, 0, 0));
    		else 
    			browser.changeSeatColor(seat.getseatNumber(), new Color (0, 255, 0));
    	}
    }
	
	public void selectSeat(User user) throws Exception {
		String movieName = browser.getMovie();
		ArrayList<Showtime> allShowTime = dbControl.getAllShowtimes(movieName);
		Showtime showtime = allShowTime.get((Integer.parseInt(browser.getShowtime()) - 1));
		ArrayList<Seat> allSeats= dbControl.getAllSeats(movieName, showtime);
		int seatNum = Integer.parseInt(browser.getSeat()); 
		Seat seat = allSeats.get(seatNum - 1);
		browser.dispose();
		if (seat != null) {
			Ticket ticket = dbControl.getID(movieName, showtime, seat);
            Payment ticketPrice = dbControl.getID(ticketPrice);
			user.newTicket(ticket);
            //if we're keeping price constant?
			//browser.displayConfirmation(ticketPrice.getPrice());
			app.payNow();
		}		
	}
}
