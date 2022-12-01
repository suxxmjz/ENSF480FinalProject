CREATE TABLE Showroom
    (showroom_ID      CHAR(4)     NOT NULL,
    theatre_name     VARCHAR(20)  NOT NULL,
    PRIMARY KEY(showroom_ID, theatre_name),
    FOREIGN KEY (theatre_name) REFERENCES Theatre(theatre_name)
    ON DELETE CASCADE       ON UPDATE CASCADE
    );
