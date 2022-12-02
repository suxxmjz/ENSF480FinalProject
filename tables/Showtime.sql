
    CREATE TABLE Showtime
    (showroom_ID      CHAR(4)     NOT NULL,
     movie_ID     VARCHAR(20)  NOT NULL,
     showing_time     DATETIME		DEFAULT NULL,
     PRIMARY KEY(showroom_ID, movie_ID, showing_time),
     FOREIGN KEY (showroom_ID) REFERENCES Showroom(showroom_ID)
     ON DELETE CASCADE       ON UPDATE CASCADE,
     FOREIGN KEY (movie_ID) REFERENCES Movie(movie_ID)
     ON DELETE CASCADE       ON UPDATE CASCADE
    );