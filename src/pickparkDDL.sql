/*
SQLyog Community v12.2.5 (64 bit)
MySQL - 6.0.11-alpha-community : Database - pickpark
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pickpark` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `pickpark`;

/*Table structure for table `booking_slot` */

DROP TABLE IF EXISTS `booking_slot`;

CREATE TABLE `booking_slot` (
  `node_id` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `time_slot` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `booking_slot` */

insert  into `booking_slot`(`node_id`,`date`,`time_slot`,`id`) values 
(43,'2019-01-23 12:15:43',21,1),
(2,'2019-01-24 17:22:16',22,2),
(23,'2019-01-23 18:09:33',34,3),
(1,'2019-01-23 18:56:45',44,4),
(2,'2019-01-23 12:13:58',45,5),
(3,'2019-01-23 18:56:56',46,6),
(3,'2019-02-18 20:00:00',40,7),
(3,'2019-02-18 20:00:00',41,8),
(3,'2019-02-18 20:00:00',42,9),
(3,'2019-02-18 20:00:00',43,10),
(3,'2019-02-18 20:00:00',44,11),
(3,'2019-02-18 20:00:00',45,12);

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `vehicle_no` varchar(50) DEFAULT NULL,
  `contact` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `customer` */

insert  into `customer`(`id`,`first_name`,`last_name`,`address`,`vehicle_no`,`contact`) values 
(1,'vishal','yadav','bilekahali','jeso55699',8800233245);

/*Table structure for table `customer_entry` */

DROP TABLE IF EXISTS `customer_entry`;

CREATE TABLE `customer_entry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `exact_entry_time` datetime DEFAULT NULL,
  `exact_exit_time` datetime DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `is_paid` tinyint(1) DEFAULT NULL,
  `penalty` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `customer_entry` */

/*Table structure for table `floor` */

DROP TABLE IF EXISTS `floor`;

CREATE TABLE `floor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parking_loc_id` int(11) DEFAULT NULL,
  `floor_number` int(11) DEFAULT NULL,
  `total_rows` int(11) DEFAULT NULL,
  `total_columns` int(11) DEFAULT NULL,
  `is_full` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `floor` */

insert  into `floor`(`id`,`parking_loc_id`,`floor_number`,`total_rows`,`total_columns`,`is_full`) values 
(1,1,1,3,2,0),
(2,1,2,1,4,0),
(3,2,1,5,10,0),
(4,3,1,2,4,0),
(5,4,1,4,4,0);

/*Table structure for table `node` */

DROP TABLE IF EXISTS `node`;

CREATE TABLE `node` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `floor_id` int(11) DEFAULT NULL,
  `type` enum('LMV','HMV','TW') DEFAULT NULL,
  `rows` int(11) DEFAULT NULL,
  `columns` int(11) DEFAULT NULL,
  `is_occupied` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=latin1;

/*Data for the table `node` */

insert  into `node`(`id`,`floor_id`,`type`,`rows`,`columns`,`is_occupied`) values 
(1,1,'LMV',1,1,0),
(2,1,'LMV',1,2,0),
(3,1,'LMV',2,1,0),
(4,1,'LMV',2,2,0),
(5,1,'LMV',3,1,0),
(6,1,'LMV',3,2,0),
(7,2,'LMV',1,1,0),
(8,2,'LMV',1,2,0),
(9,2,'LMV',1,3,0),
(10,2,'LMV',1,4,0),
(11,3,'LMV',1,1,0),
(12,3,'LMV',1,2,0),
(13,3,'LMV',1,3,0),
(14,3,'LMV',1,4,0),
(15,3,'LMV',1,5,0),
(16,3,'LMV',1,6,0),
(17,3,'LMV',1,7,0),
(18,3,'LMV',1,8,0),
(19,3,'LMV',1,9,0),
(20,3,'LMV',1,10,0),
(21,3,'LMV',2,1,0),
(22,3,'LMV',2,2,0),
(23,3,'LMV',2,3,0),
(24,3,'LMV',2,4,0),
(25,3,'LMV',2,5,0),
(26,3,'LMV',2,6,0),
(27,3,'LMV',2,7,0),
(28,3,'LMV',2,8,0),
(29,3,'LMV',2,9,0),
(30,3,'LMV',2,10,0),
(31,3,'LMV',3,1,0),
(32,3,'LMV',3,2,0),
(33,3,'LMV',3,3,0),
(34,3,'LMV',3,4,0),
(35,3,'LMV',3,5,0),
(36,3,'LMV',3,6,0),
(37,3,'LMV',3,7,0),
(38,3,'LMV',3,8,0),
(39,3,'LMV',3,9,0),
(40,3,'LMV',3,10,0),
(41,3,'LMV',4,1,0),
(42,3,'LMV',4,2,0),
(43,3,'LMV',4,3,0),
(44,3,'LMV',4,4,0),
(45,3,'LMV',4,5,0),
(46,3,'LMV',4,6,0),
(47,3,'LMV',4,7,0),
(48,3,'LMV',4,8,0),
(49,3,'LMV',4,9,0),
(50,3,'LMV',4,10,0),
(51,3,'LMV',5,1,0),
(52,3,'LMV',5,2,0),
(53,3,'LMV',5,3,0),
(54,3,'LMV',5,4,0),
(55,3,'LMV',5,5,0),
(56,3,'LMV',5,6,0),
(57,3,'LMV',5,7,0),
(58,3,'LMV',5,8,0),
(59,3,'LMV',5,9,0),
(60,3,'LMV',5,10,0),
(61,4,'LMV',1,1,0),
(62,4,'LMV',1,2,0),
(63,4,'LMV',1,3,0),
(64,4,'LMV',1,4,0),
(65,4,'LMV',2,1,0),
(66,4,'LMV',2,2,0),
(67,4,'LMV',2,3,0),
(68,4,'LMV',2,4,0),
(69,5,'LMV',1,1,0),
(70,5,'LMV',1,2,0),
(71,5,'LMV',1,3,0),
(72,5,'LMV',1,4,0),
(73,5,'LMV',2,1,0),
(74,5,'LMV',2,2,0),
(75,5,'LMV',2,3,0),
(76,5,'LMV',2,4,0),
(77,5,'LMV',3,1,0),
(78,5,'LMV',3,2,0),
(79,5,'LMV',3,3,0),
(80,5,'LMV',3,4,0),
(81,5,'LMV',4,1,0),
(82,5,'LMV',4,2,0),
(83,5,'LMV',4,3,0),
(84,5,'LMV',4,4,0);

/*Table structure for table `parking_loc` */

DROP TABLE IF EXISTS `parking_loc`;

CREATE TABLE `parking_loc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) DEFAULT NULL,
  `latitude` decimal(7,4) DEFAULT NULL,
  `longitude` decimal(7,4) DEFAULT NULL,
  `zip` int(11) DEFAULT NULL,
  `is_slot_avaialble` tinyint(1) DEFAULT NULL,
  `no_of_floor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `parking_loc` */

insert  into `parking_loc`(`id`,`address`,`latitude`,`longitude`,`zip`,`is_slot_avaialble`,`no_of_floor`) values 
(1,'Billekahali','12.8990','77.6080',560076,1,1),
(2,'Ranka Colony','12.9055','77.6037',560077,1,1),
(3,'Lake','12.9062','77.6131',560076,1,1),
(4,'Mico Layout','12.9088','77.6076',560078,1,1);

/*Table structure for table `parking_reservation` */

DROP TABLE IF EXISTS `parking_reservation`;

CREATE TABLE `parking_reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `booking_date` datetime DEFAULT NULL,
  `parking_slot_id` int(11) DEFAULT NULL,
  `payment_status` enum('paid','unpaid') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `parking_reservation` */

insert  into `parking_reservation`(`id`,`customer_id`,`start_date`,`duration`,`booking_date`,`parking_slot_id`,`payment_status`) values 
(1,5,'2019-02-18 20:00:00',10800000,'2019-01-23 21:57:16',3,'unpaid');

/*Table structure for table `pass` */

DROP TABLE IF EXISTS `pass`;

CREATE TABLE `pass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `purchase_date` datetime DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `cost` bigint(20) DEFAULT NULL,
  `type` enum('LMV','HMV','TW') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `pass` */

insert  into `pass`(`id`,`customer_id`,`purchase_date`,`start_date`,`end_date`,`cost`,`type`) values 
(1,4,'2019-01-22 22:43:56','2019-02-11 00:00:00','2019-02-14 00:00:00',60,'TW'),
(2,1,'2019-01-22 22:44:36','2019-02-13 00:00:00','2019-02-14 00:00:00',20,'TW'),
(3,2,'2019-01-22 22:44:54','2019-02-13 00:00:00','2019-02-16 00:00:00',60,'TW'),
(4,3,'2019-01-22 22:45:16','2019-02-18 00:00:00','2019-02-19 00:00:00',20,'TW');

/*Table structure for table `price` */

DROP TABLE IF EXISTS `price`;

CREATE TABLE `price` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` enum('LMV','HMV','TW') DEFAULT NULL,
  `baseprice` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `price` */

insert  into `price`(`id`,`type`,`baseprice`) values 
(1,'LMV','30.00'),
(2,'HMV','50.00'),
(3,'TW','20.00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
