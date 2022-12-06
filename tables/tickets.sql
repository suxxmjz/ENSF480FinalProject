DROP TABLE IF EXISTS ticket;

CREATE TABLE ticket (
  id int NOT NULL AUTO_INCREMENT,
  seatNo int NOT NULL,
  showroom_ID  CHAR(4) NOT NULL,
  movieName varchar(50) NOT NULL,
  datePurchased varchar(10) NOT NULL, /* dd-mm-yyyy */
  email varchar(50) NOT NULL,
  FOREIGN KEY (showroom_ID) REFERENCES Showroom(showroom_ID)
  PRIMARY KEY (id)
);

