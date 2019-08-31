CREATE DATABASE  IF NOT EXISTS `login-webapp` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `login-webapp`;

-- Table structure for table `logindata`
--

DROP TABLE IF EXISTS `logindata`;
CREATE TABLE `logindata` (
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
