DROP TABLE IF EXISTS `seats` ;

CREATE TABLE `seats` (
  `Seat Number` int NOT NULL,
  `Row Number` int NOT NULL,
  `Available seat` BIT(1) NOT NULL,
  `Movie` VARCHAR(50) NOT NULL,
  `Show Time` int NOT NULL,
  `Show Room` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`Seat Number`,`Row Number`, `Movie`,`Show Time`,`Show Room`)
);


INSERT INTO `seats` VALUES (1,'A','The Terminator', '3:30 pm', 'ShowRoom 3');
INSERT INTO `seats` VALUES (2,'A','The Terminator', '3:30 pm', 'ShowRoom 3');
INSERT INTO `seats` VALUES (3,'A','The Terminator', '3:30 pm', 'ShowRoom 3');
INSERT INTO `seats` VALUES (4,'A','The Terminator', '3:30 pm', 'ShowRoom 3');
INSERT INTO `seats` VALUES (1,'B','The Terminator', '3:30 pm', 'ShowRoom 3');
INSERT INTO `seats` VALUES (2,'B','The Terminator', '3:30 pm', 'ShowRoom 3');
INSERT INTO `seats` VALUES (3,'B','The Terminator', '3:30 pm', 'ShowRoom 3');
INSERT INTO `seats` VALUES (4,'B','The Terminator', '3:30 pm', 'ShowRoom 3');

INSERT INTO `seats` VALUES (1,'A','The Terminator', '5:30 pm', 'ShowRoom 7');
INSERT INTO `seats` VALUES (2,'A','The Terminator', '5:30 pm', 'ShowRoom 7');
INSERT INTO `seats` VALUES (3,'A','The Terminator', '5:30 pm', 'ShowRoom 7');
INSERT INTO `seats` VALUES (4,'A','The Terminator', '5:30 pm', 'ShowRoom 7');
INSERT INTO `seats` VALUES (1,'B','The Terminator', '5:30 pm', 'ShowRoom 7');
INSERT INTO `seats` VALUES (2,'B','The Terminator', '5:30 pm', 'ShowRoom 7');
INSERT INTO `seats` VALUES (3,'B','The Terminator', '5:30 pm', 'ShowRoom 7');
INSERT INTO `seats` VALUES (4,'B','The Terminator', '5:30 pm', 'ShowRoom 7');


INSERT INTO `seats` VALUES (1,'A','Snow White', '3:30 pm', 'ShowRoom 5');
INSERT INTO `seats` VALUES (2,'A','Snow White', '3:30 pm', 'ShowRoom 5');
INSERT INTO `seats` VALUES (3,'A','Snow White', '3:30 pm', 'ShowRoom 5');
INSERT INTO `seats` VALUES (4,'A','Snow White', '3:30 pm', 'ShowRoom 5');
INSERT INTO `seats` VALUES (1,'B','Snow White', '3:30 pm', 'ShowRoom 5');
INSERT INTO `seats` VALUES (2,'B','Snow White', '3:30 pm', 'ShowRoom 5');
INSERT INTO `seats` VALUES (3,'B','Snow White', '3:30 pm', 'ShowRoom 5');
INSERT INTO `seats` VALUES (4,'B','Snow White', '3:30 pm', 'ShowRoom 5');


INSERT INTO `seats` VALUES (1,'A','Snow White', '7:30 pm', 'ShowRoom 5');
INSERT INTO `seats` VALUES (2,'A','Snow White', '7:30 pm', 'ShowRoom 5');
INSERT INTO `seats` VALUES (3,'A','Snow White', '7:30 pm', 'ShowRoom 5');
INSERT INTO `seats` VALUES (4,'A','Snow White', '7:30 pm', 'ShowRoom 5');
INSERT INTO `seats` VALUES (1,'B','Snow White', '7:30 pm', 'ShowRoom 5');
INSERT INTO `seats` VALUES (2,'B','Snow White', '7:30 pm', 'ShowRoom 5');
INSERT INTO `seats` VALUES (3,'B','Snow White', '7:30 pm', 'ShowRoom 5');
INSERT INTO `seats` VALUES (4,'B','Snow White', '7:30 pm', 'ShowRoom 5');


DESC seats;
