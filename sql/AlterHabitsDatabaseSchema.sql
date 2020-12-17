-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: ra1.anystream.eu    Database: AlterHabits
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activities`
--

DROP TABLE IF EXISTS `activities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activities` (
  `activity_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(40) NOT NULL,
  PRIMARY KEY (`activity_id`),
  UNIQUE KEY `activity_name` (`activity_name`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activities`
--

LOCK TABLES `activities` WRITE;
/*!40000 ALTER TABLE `activities` DISABLE KEYS */;
INSERT INTO `activities` VALUES (6,'aqua aerobic'),(17,'basketball'),(15,'beach volley'),(7,'capoeira'),(25,'climbing'),(23,'crosstraining'),(11,'dance'),(26,'ems'),(16,'football'),(14,'golf'),(13,'ice skating'),(1,'indoor cycling'),(9,'karate'),(22,'parkour'),(24,'personal training'),(2,'pilates'),(20,'ping pong'),(12,'pole dance'),(19,'running'),(10,'self defence'),(21,'squash'),(4,'swimming'),(8,'tai chi'),(18,'tennis'),(5,'water polo'),(3,'yoga');
/*!40000 ALTER TABLE `activities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit_debit_cards`
--

DROP TABLE IF EXISTS `credit_debit_cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credit_debit_cards` (
  `credit_debit_card_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `credit_debit_card_number` varchar(20) NOT NULL,
  `credit_debit_card_expiration_month` int(11) NOT NULL,
  `credit_debit_card_expiration_year` int(11) NOT NULL,
  `credit_debit_card_name` varchar(60) NOT NULL,
  PRIMARY KEY (`credit_debit_card_id`),
  UNIQUE KEY `credit_debit_card_number` (`credit_debit_card_number`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit_debit_cards`
--

LOCK TABLES `credit_debit_cards` WRITE;
/*!40000 ALTER TABLE `credit_debit_cards` DISABLE KEYS */;
/*!40000 ALTER TABLE `credit_debit_cards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `reservation_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `shop_id` int(10) unsigned NOT NULL,
  `activity_id` int(10) unsigned NOT NULL,
  `reservation_date` datetime DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  UNIQUE KEY `user_id` (`user_id`,`shop_id`,`reservation_date`),
  KEY `SHOPS_id_ON_reservation` (`shop_id`),
  KEY `activity_id_ON_reservation` (`activity_id`),
  CONSTRAINT `SHOPS_id_ON_reservation` FOREIGN KEY (`shop_id`) REFERENCES `shops` (`shop_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `activity_id_ON_reservation` FOREIGN KEY (`activity_id`) REFERENCES `activities` (`activity_id`),
  CONSTRAINT `user_id_ON_reservation` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `role_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role` varchar(30) NOT NULL,
  `available_appointments` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (2,'ROLE_USER',NULL),(3,'ROLE_PREMIUM',NULL),(4,'ROLE_ELIT',NULL);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shops`
--

DROP TABLE IF EXISTS `shops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shops` (
  `shop_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(100) NOT NULL,
  `longitude` varchar(50) NOT NULL,
  `latitude` varchar(50) NOT NULL,
  `potential_partner` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`shop_id`),
  UNIQUE KEY `shop_name` (`shop_name`),
  UNIQUE KEY `longitude` (`longitude`,`latitude`),
  UNIQUE KEY `UKfqj0pfjkt5nt3pnev40a1dixi` (`longitude`,`latitude`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shops`
--

LOCK TABLES `shops` WRITE;
/*!40000 ALTER TABLE `shops` DISABLE KEYS */;
INSERT INTO `shops` VALUES (1,'COMRADERY','23.727639','37.983910','',''),(2,'ATHENS YOGA CENTER','23.727679','37.988950','',''),(3,'GYM TONIC','23.737839','37.983710','',''),(4,'GRAFTS HELLAS','23.698867','37.935194','',''),(5,'PERISTERI ATHLETIC CLUB','23.6865823','38.0042262','',''),(6,'SPORTSPIRIT','23.805026','37.820224','',''),(7,'BANZO DE SENZALA ATENAS','23.726392','37.978585','',''),(8,'PERIKLIS TRAINING','23.821951','38.027454','',''),(9,'GAZI CROSSFIT','23.7072204','37.9753153','',''),(10,'NIKI KONTAXAKI DANCE SCHOOL','23.742167','38.022521','',''),(11,'ATHENS EMS','23.726254','37.976083','',''),(12,'AEK FC','23.929729','37.957489','',''),(13,'GLYFADA GOLF COURSE','23.743326','37.8763477','',''),(14,'ICE ARENA','23.754068','37.981072','',''),(15,'OAKA 37','23.7802807','38.0382739','',''),(16,'OKINAWA SHORINRYU SHIDOKAN KARATEDO SHIRASAGI DOJO ATHENS','23.763201','37.995786','',''),(17,'ATHENS PARKOUR ACADEMY','23.733518','37.958011','',''),(18,'NYSY','23.727764','37.978001','',''),(19,'PING PONG ZOGRAFOU','23.779138','37.972426','',''),(20,'POLESSENCE','23.7575145','37.9829508','',''),(21,'RUNNINGREECE','23.7963672','38.022229','',''),(22,'ATRAPOS','23.675279','37.961324','',''),(23,'OMILOS ANTISFAIRISEOS ATHINON','23.7336921','37.9694625','',''),(24,'YAVA','23.7691317','37.9997799','',''),(25,'TAICHI ATHENS','23.753717','38.04498','',''),(26,'NAUTICAL CLUB OF KALAMAKI-ATHENS','23.708882','37.912081','','');
/*!40000 ALTER TABLE `shops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shops_activities`
--

DROP TABLE IF EXISTS `shops_activities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shops_activities` (
  `shops_activities_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `shop_id` int(10) unsigned NOT NULL,
  `activity_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`shops_activities_id`),
  UNIQUE KEY `shop_id` (`shop_id`,`activity_id`),
  KEY `fk_activity_id_ON_SHOPS_activities` (`activity_id`),
  CONSTRAINT `fk_activity_id_ON_SHOPS_activities` FOREIGN KEY (`activity_id`) REFERENCES `activities` (`activity_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_shop_id_ON_SHOPS_activities` FOREIGN KEY (`shop_id`) REFERENCES `shops` (`shop_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shops_activities`
--

LOCK TABLES `shops_activities` WRITE;
/*!40000 ALTER TABLE `shops_activities` DISABLE KEYS */;
INSERT INTO `shops_activities` VALUES (1,1,23),(2,2,3),(5,3,1),(3,3,2),(4,3,24),(7,4,3),(6,4,6),(10,4,11),(8,4,23),(9,4,24),(11,5,17),(12,6,15),(13,7,7),(15,8,19),(14,8,25),(17,9,2),(16,9,23),(18,10,11),(19,11,26),(20,12,16),(21,13,14),(22,14,13),(23,15,1),(24,16,9),(25,17,22),(26,18,2),(41,18,3),(27,19,20),(28,20,12),(29,21,19),(30,22,10),(31,23,18),(32,23,21),(37,24,1),(34,24,2),(33,24,4),(38,24,10),(35,24,24),(36,24,26),(39,25,8),(40,26,5);
/*!40000 ALTER TABLE `shops_activities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_appointments`
--

DROP TABLE IF EXISTS `user_appointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_appointments` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `available_appointments` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_id_ON_user_appointments` (`user_id`),
  CONSTRAINT `fk_user_id_ON_user_appointments` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_appointments`
--

LOCK TABLES `user_appointments` WRITE;
/*!40000 ALTER TABLE `user_appointments` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_appointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_contact_info`
--

DROP TABLE IF EXISTS `user_contact_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_contact_info` (
  `contact_info_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(200) NOT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  `mobile_number` varchar(10) NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`contact_info_id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `mobile_number` (`mobile_number`),
  KEY `fk_user_id_ON_contact_info` (`user_id`),
  CONSTRAINT `fk_user_id_ON_contact_info` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_contact_info_chk_mobnum_1` CHECK (regexp_like(`mobile_number`,_utf8mb4'^69[0-9]{8}$')),
  CONSTRAINT `user_contact_info_chk_phonnum_1` CHECK (regexp_like(`phone_number`,_utf8mb4'^21[0-9]{8}$'))
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_contact_info`
--

LOCK TABLES `user_contact_info` WRITE;
/*!40000 ALTER TABLE `user_contact_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_contact_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_credit_debit_card`
--

DROP TABLE IF EXISTS `user_credit_debit_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_credit_debit_card` (
  `user_credit_debit_card_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `credit_debit_card_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`user_credit_debit_card_id`),
  UNIQUE KEY `user_id` (`user_id`,`credit_debit_card_id`),
  KEY `fk_credit_debit_card_id_ON_user_credit_debit_card` (`credit_debit_card_id`),
  CONSTRAINT `fk_credit_debit_card_id_ON_user_credit_debit_card` FOREIGN KEY (`credit_debit_card_id`) REFERENCES `credit_debit_cards` (`credit_debit_card_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_id_ON_user_credit_debit_card` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_credit_debit_card`
--

LOCK TABLES `user_credit_debit_card` WRITE;
/*!40000 ALTER TABLE `user_credit_debit_card` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_credit_debit_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_personal_info`
--

DROP TABLE IF EXISTS `user_personal_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_personal_info` (
  `personal_info_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `date_of_birth` date NOT NULL,
  `gender` varchar(20) NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`personal_info_id`),
  KEY `FK_user_id_ON_personal_info` (`user_id`),
  CONSTRAINT `FK_user_id_ON_personal_info` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `users_chk_dob_yr_1` CHECK ((year(`date_of_birth`) > 1950)),
  CONSTRAINT `users_chk_dob_yr_2` CHECK (((month(`date_of_birth`) >= 1) and (month(`date_of_birth`) <= 12))),
  CONSTRAINT `users_chk_dob_yr_3` CHECK (((dayofmonth(`date_of_birth`) >= 1) and (dayofmonth(`date_of_birth`) <= 31))),
  CONSTRAINT `users_chk_sex` CHECK ((`gender` in (_utf8mb4'Male',_utf8mb4'Female',_utf8mb4'Other')))
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_personal_info`
--

LOCK TABLES `user_personal_info` WRITE;
/*!40000 ALTER TABLE `user_personal_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_personal_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `user_password` varchar(68) NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`),
  KEY `FK_role_id` (`role_id`),
  CONSTRAINT `FK_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
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

-- Dump completed on 2020-09-18 14:20:52
