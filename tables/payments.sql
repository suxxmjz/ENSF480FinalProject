DROP TABLE IF EXISTS payment;

CREATE TABLE payment(
    ticketID int NOT NULL,
    price float NOT NULL,
    email varchar(50) NOT NULL,
    cardNumber int(10) NOT NULL,
    refunded BIT(1) DEFAULT 0, /*check if refunded already, so user can't scam a double refund, unless we delete a payment when it's refunded*/
    PRIMARY KEY (ticketID),
    FOREIGN KEY(ticketID) REFERENCES Ticket(id)

);
