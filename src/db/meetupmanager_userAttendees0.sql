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
-- Table structure for table `userAttendees`
--

DROP TABLE IF EXISTS `userAttendees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userAttendees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_meetups` int(11) NOT NULL,
  `id_users` int(11) NOT NULL,
  `isRsvp` tinyint(1) DEFAULT NULL,
  `id_ratings` int(11) DEFAULT NULL,
  `comments` mediumtext,
  PRIMARY KEY (`id`),
  KEY `fk_userAttendees_ratings1_idx` (`id_ratings`),
  KEY `fk_userAttendees_users1_idx` (`id_users`),
  KEY `fk_userAttendees_meetups1_idx` (`id_meetups`),
  CONSTRAINT `fk_userAttendees_meetups1` FOREIGN KEY (`id_meetups`) REFERENCES `meetups` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_userAttendees_ratings1` FOREIGN KEY (`id_ratings`) REFERENCES `ratings` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_userAttendees_users1` FOREIGN KEY (`id_users`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userAttendees`
--

LOCK TABLES `userAttendees` WRITE;
/*!40000 ALTER TABLE `userAttendees` DISABLE KEYS */;
INSERT INTO `userAttendees` VALUES (173,19,1,1,1,'Was pretty fun, would do again'),(174,19,2,1,1,'That was amazing!'),(175,19,3,1,1,NULL),(176,19,4,1,1,NULL),(177,19,5,1,2,NULL),(178,19,6,1,1,NULL),(179,19,7,0,1,NULL),(180,19,8,0,1,NULL),(181,19,9,1,1,'This was pretty fun'),(182,19,10,1,1,NULL),(183,19,11,1,2,'Nothing to complain about here'),(184,20,1,1,2,'This was pretty good!'),(185,20,2,1,3,NULL),(186,20,3,1,2,NULL),(187,21,4,1,3,'Eh it could have been better'),(188,21,5,1,2,NULL),(189,21,6,1,1,'Amazing!'),(190,21,7,0,1,NULL),(191,21,8,0,1,NULL),(192,21,9,1,1,NULL),(193,21,10,1,1,NULL),(194,21,11,1,4,'Didn\'t really like it'),(195,21,12,1,1,'I liked this alot'),(196,21,20,1,1,NULL),(197,21,19,1,1,NULL),(198,1,2,0,NULL,NULL),(199,1,2,0,NULL,NULL),(200,18,2,0,NULL,NULL),(201,18,2,0,NULL,NULL),(202,18,2,0,NULL,NULL),(203,18,2,0,NULL,NULL),(204,18,2,0,NULL,NULL),(205,5,2,0,NULL,NULL),(206,5,2,0,NULL,NULL),(207,1,2,0,NULL,NULL),(208,16,2,0,NULL,NULL),(209,16,2,0,NULL,NULL),(210,16,2,0,NULL,NULL),(211,16,2,0,NULL,NULL),(212,16,2,0,NULL,NULL),(213,16,2,0,NULL,NULL),(214,16,2,0,NULL,NULL),(215,16,2,0,NULL,NULL),(216,16,2,0,NULL,NULL),(217,16,2,0,NULL,NULL),(218,16,2,0,NULL,NULL),(219,16,2,0,NULL,NULL),(220,16,2,0,NULL,NULL),(221,16,2,0,NULL,NULL),(222,16,2,0,NULL,NULL),(223,16,2,0,NULL,NULL),(224,16,2,0,NULL,NULL),(225,16,2,0,NULL,NULL),(226,16,2,0,NULL,NULL),(227,16,2,0,NULL,NULL),(228,16,2,0,NULL,NULL),(229,16,2,0,NULL,NULL),(230,16,2,0,NULL,NULL),(231,1,2,0,NULL,NULL),(232,1,2,0,NULL,NULL),(233,1,2,0,NULL,NULL),(234,1,2,0,NULL,NULL),(235,1,2,0,NULL,NULL),(236,1,2,0,NULL,NULL),(237,1,2,0,NULL,NULL),(238,1,2,0,NULL,NULL),(239,1,2,0,NULL,NULL),(240,1,2,0,NULL,NULL),(241,1,2,0,NULL,NULL),(242,1,2,0,NULL,NULL),(243,1,2,0,NULL,NULL),(244,1,1,0,NULL,NULL),(245,1,1,0,NULL,NULL),(246,1,1,0,NULL,NULL);
/*!40000 ALTER TABLE `userAttendees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-24 19:06:24
