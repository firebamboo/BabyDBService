# MySQL-Front 5.1  (Build 2.7)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: babycenter
# ------------------------------------------------------
# Server version 5.1.57-community

DROP DATABASE IF EXISTS `babycenter`;
CREATE DATABASE `babycenter` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `babycenter`;

#
# Source for table basicinfo
#

DROP TABLE IF EXISTS `basicinfo`;
CREATE TABLE `basicinfo` (
  `Id` int(11) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `photo` mediumblob,
  UNIQUE KEY `Id` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table basicinfo
#
LOCK TABLES `basicinfo` WRITE;
/*!40000 ALTER TABLE `basicinfo` DISABLE KEYS */;

INSERT INTO `basicinfo` VALUES (10,'name1','1990-12-30',NULL);
/*!40000 ALTER TABLE `basicinfo` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
