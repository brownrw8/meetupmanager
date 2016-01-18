CREATE DATABASE  IF NOT EXISTS `meetupmanager` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `meetupmanager`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: meetupmanager
-- ------------------------------------------------------
-- Server version	5.5.46-0ubuntu0.14.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `username` varchar(100) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Robert','Brown','rbrown','rbrown@roadrunnercom'),(2,'Steven','Winter','swinter','swinter@prexarcom'),(4,'Bob','Masterton','bmasterton','crazydude@boatin.ca'),(5,'Helen','Brooks','hbrooks','surfin@usa.com'),(6,'Quentin','Nicholas','qnicholas','musicdude@yahoo.com'),(7,'Ben','Water','bwater7','bwater@yahoo.com'),(8,'Will','Xen','wxen','scienceman@smithsonian.com'),(9,'Brian','Hu','bhu','ilovecooking11@gmail.com'),(10,'David','Wang','david','david44@gmail.com'),(11,'David','Wort','david1','snowman22@gmail.com'),(12,'Charles','Brent','cbrent66','cbrent@roadrunner.com'),(13,'Paul','Jordan','jordan3','rainyday@roadrunner.com'),(14,'Walter','Gronkite','wgronkite1','wgronkite@yahoo.com'),(15,'Peter','Smith','psmith1','psmith@yahoo.com'),(16,'David','Smith','dsmith207','4x4man@yahoo.com'),(17,'Greg','Smith','greg','gregsgmail@gmail.com'),(18,'Paul','Williams','paul11','williams99@gmail.com'),(19,'Dan','Trumpet','dan776','trumpetdan55@gmai.\\com'),(20,'Kathy','Fornier','kfornier','artsandcrafts@gmail.com');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-18 13:12:32
