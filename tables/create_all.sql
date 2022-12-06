DROP DATABASE IF EXISTS `480_final_project`;
CREATE DATABASE `480_final_project`;
<<<<<<< HEAD
USE `480_final_project`;
=======
>>>>>>> efef778d779ff575af9347d1eecb7123e37be885

DROP TABLE IF EXISTS `users` ;

CREATE TABLE users (
  Firstname varchar(45) DEFAULT NULL,
  Lastname varchar(45) DEFAULT NULL,
  UserAddress varchar(45) DEFAULT NULL,
  CardNumber int DEFAULT NULL,
  Email varchar(45) NOT NULL,
  Password varchar(45) DEFAULT NULL,
  is_registered BIT(1),
  PRIMARY KEY (Email)
);

DROP TABLE IF EXISTS `theatre` ;
CREATE TABLE `theatre`(
    theatre_name VARCHAR(50) NOT NULL,
    PRIMARY KEY(theatre_name)
    );

DROP TABLE IF EXISTS `Showroom` ;

CREATE TABLE Showroom
(showroom_ID      char(4)   NOT NULL,
theatre_name     VARCHAR(50)  NOT NULL,
PRIMARY KEY(showroom_ID, theatre_name),
FOREIGN KEY (theatre_name) REFERENCES Theatre(theatre_name)
ON DELETE CASCADE       ON UPDATE CASCADE
);

DROP TABLE IF EXISTS `movies` ;

CREATE TABLE movies (
    MovieTitle VARCHAR(50) NOT NULL,
    Genre VARCHAR(50) DEFAULT NULL,
    RunTime INT DEFAULT NULL,
<<<<<<< HEAD
    Announcement DATE,
=======
>>>>>>> efef778d779ff575af9347d1eecb7123e37be885
    PRIMARY KEY(MovieTitle)
);


DROP TABLE IF EXISTS `Showtime` ;

CREATE TABLE Showtime
<<<<<<< HEAD
(   id int NOT NULL unique,
	showroom_ID      char(4)   NOT NULL,
=======
(   showroom_ID      char(4)   NOT NULL,
>>>>>>> efef778d779ff575af9347d1eecb7123e37be885
    theatre_name     VARCHAR(50)  NOT NULL,
    movie_name     VARCHAR(50)        NOT NULL,
    showing_time   DATETIME		NOT NULL,
    FOREIGN KEY (showroom_ID, theatre_name) REFERENCES Showroom(showroom_ID, theatre_name)
    ON DELETE CASCADE       ON UPDATE CASCADE,
    FOREIGN KEY (movie_name) REFERENCES Movies(MovieTitle)
    ON DELETE CASCADE       ON UPDATE CASCADE,
    PRIMARY KEY(showroom_ID, movie_name, showing_time)
);



DROP TABLE IF EXISTS `ticket` ;
CREATE TABLE ticket (
  id int NOT NULL AUTO_INCREMENT,
  seatNo int NOT NULL,
  showroom_ID  CHAR(4) NOT NULL,
  movieName varchar(50) NOT NULL,
  datePurchased DATE NOT NULL, /* dd-mm-yyyy */
  showing_time DATETIME		NOT NULL,
  email varchar(50) NOT NULL,
<<<<<<< HEAD
  price float NOT NULL,
=======
>>>>>>> efef778d779ff575af9347d1eecb7123e37be885
  FOREIGN KEY (showroom_ID, movieName, showing_time) REFERENCES Showtime(showroom_ID, movie_name, showing_time),
  PRIMARY KEY (id)
);


DROP TABLE IF EXISTS `payment`;

CREATE TABLE payment(
    ticketID int NOT NULL,
    price float NOT NULL,
    email varchar(50) NOT NULL,
    cardNumber int(10) NOT NULL,
    refunded BIT(1) DEFAULT 0, /*check if refunded already, so user can't scam a double refund, unless we delete a payment when it's refunded*/
    PRIMARY KEY (ticketID),
    FOREIGN KEY(ticketID) REFERENCES Ticket(id)

);



DROP TABLE IF EXISTS `seats` ;

CREATE TABLE seats (
  SeatNumber int NOT NULL,
<<<<<<< HEAD
=======
  RowNumber int NOT NULL,
>>>>>>> efef778d779ff575af9347d1eecb7123e37be885
  Available BIT(1) NOT NULL,
  Movie VARCHAR(50) NOT NULL,
  ShowTime DATETIME NOT NULL,
  ShowRoom VARCHAR(4) NOT NULL,
<<<<<<< HEAD
  PRIMARY KEY (SeatNumber, Movie, ShowTime, ShowRoom),
  FOREIGN KEY (ShowRoom, Movie, ShowTime) REFERENCES Showtime(showroom_ID, movie_name, showing_time)
);

DROP TABLE IF EXISTS `voucher` ;
CREATE TABLE voucher (
	code_ INT NOT NULL,
    amount double,
    expiration DATE,
    email VARCHAR(50),
    primary key (code_)
);
=======
  PRIMARY KEY (SeatNumber, RowNumber, Movie, ShowTime, ShowRoom),
  FOREIGN KEY (ShowRoom, Movie, ShowTime) REFERENCES Showtime(showroom_ID, movie_name, showing_time)
);




 
>>>>>>> efef778d779ff575af9347d1eecb7123e37be885
