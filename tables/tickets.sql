DROP TABLE IF EXISTS ticket;

CREATE TABLE ticket (
  id int NOT NULL AUTO_INCREMENT,
  seatNo int NOT NULL,
  movieName varchar(50) NOT NULL,
  datePurchased varchar(10) NOT NULL, /* dd-mm-yyyy */
  email varchar(50) NOT NULL,
  PRIMARY KEY (id)
);

