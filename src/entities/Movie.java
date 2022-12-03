
package entities;

import java.time.LocalDate;

public class Movie {
    private String movieName;
    private String genre;
    private int runTime;
    private LocalDate announcement;


    public Movie (String movieName, String genre, int runTime, LocalDate announcement){
        this.movieName = movieName;
        this.genre = genre;
        this.runTime = runTime;
        this.announcement = announcement;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getGenre() {
        return genre;
    }

    public int getRunTime() {
        return runTime;
    }

    public LocalDate getAnnouncement() {
        return announcement;
    }

}
