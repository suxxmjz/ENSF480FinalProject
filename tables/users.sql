DROP TABLE IF EXISTS `users` ;

CREATE TABLE `users` (
  `Name` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `CardNumber` int DEFAULT NULL,
  `Email` varchar(45) NOT NULL,
  `Password` varchar(45) DEFAULT NULL,
  is_registered BIT(1),
  PRIMARY KEY (`Email`)
);


INSERT INTO `users` VALUES ('sukriti','123 uofc',123456, 'sukriti@email.com','password');
INSERT INTO `users` VALUES ('caroline','345 abc',789101,'caroline@email.com','hello123');
INSERT INTO `users` VALUES ('mohammed','234 xyz',893452,'mohammed@email.com','ensf');
INSERT INTO `users` VALUES ('labib', '874 efg', 975124,'labib@email.com','ucalgary');

DESC users;
