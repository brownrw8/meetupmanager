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
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `latitude` decimal(17,14) DEFAULT NULL,
  `longitude` decimal(17,14) DEFAULT NULL,
  `id_eventCategories` int(11) NOT NULL,
  `id_users` int(11) NOT NULL,
  `isRecurring` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_events_users_idx` (`id_users`),
  KEY `fk_events_eventCategories1_idx` (`id_eventCategories`),
  CONSTRAINT `fk_events_eventCategories1` FOREIGN KEY (`id_eventCategories`) REFERENCES `eventCategories` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_events_users` FOREIGN KEY (`id_users`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (1,'Bob\'s Boating Bonanza',40.00001000000000,-70.00001000000000,1,4,0),(2,'Kathy\'s Arts & Crafts',40.00101000000000,-70.30001000000000,2,20,1),(3,'Basketball Pickup',40.02001000000000,-70.00001000000000,11,13,1),(4,'Annual Science Fair',40.05001000000000,-70.10001000000000,8,8,0),(5,'How to Succeed in Business',40.10001000000000,-70.80001000000000,7,12,1),(6,'How to Succeed in Business - On Stage',40.40001000000000,-70.00011000000000,9,14,0),(7,'Pet Show',40.42010000000000,-70.00011000000000,10,16,0),(8,'Weekly Book Cluib',40.42010000000000,-70.99011000000000,4,4,1),(9,'Live Music - Beginner\'s Tutorial',40.45010000000000,-70.08011000000000,6,19,1),(10,'Waterskiing Workshop',40.00010000000000,-70.00001000000000,1,20,0);
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-18 13:12:36
