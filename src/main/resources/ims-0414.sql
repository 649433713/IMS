CREATE DATABASE  IF NOT EXISTS `ims` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ims`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: ims
-- ------------------------------------------------------
-- Server version	5.7.18

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
-- Table structure for table `brand_list`
--

DROP TABLE IF EXISTS `brand_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brand_list` (
  `brand` varchar(45) NOT NULL,
  PRIMARY KEY (`brand`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand_list`
--

LOCK TABLES `brand_list` WRITE;
/*!40000 ALTER TABLE `brand_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `brand_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buyer_info`
--

DROP TABLE IF EXISTS `buyer_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buyer_info` (
  `id` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `contact` varchar(32) NOT NULL,
  `comments` varchar(64) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='进货商信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buyer_info`
--

LOCK TABLES `buyer_info` WRITE;
/*!40000 ALTER TABLE `buyer_info` DISABLE KEYS */;
INSERT INTO `buyer_info` VALUES ('124343','yinywf','15996262601',NULL,'2019-04-13 17:20:01','2019-04-13 17:20:01');
/*!40000 ALTER TABLE `buyer_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `card_no` varchar(45) NOT NULL,
  `customer_name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `comments` varchar(45) DEFAULT NULL,
  `invoice_info` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`card_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_detail` (
  `detail_id` varchar(32) NOT NULL,
  `order_id` varchar(32) NOT NULL,
  `product_id` varchar(32) NOT NULL,
  `product_name` varchar(64) NOT NULL,
  `product_price` decimal(8,2) NOT NULL,
  `product_quantity` int(11) NOT NULL,
  `product_icon` varchar(512) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`detail_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES ('1508170317741161760','1508170317507262162','1234568','芒果冰',20.00,1,NULL,'2017-10-14 04:56:18','2017-10-16 16:11:42'),('1508170317786288678','1508170317507262162','123457','皮皮虾',3.20,2,NULL,'2017-10-14 04:56:18','2017-10-16 16:11:42'),('1508436537148471622','1508436537137963462','0000003','皮蛋粥',3.10,1,'http://i3.meishichina.com/attachment/recipe/201001/201001032036581.JPG@!p800','2017-10-14 04:56:18','2017-10-18 14:40:13'),('1508436760195497967','1508436760192978833','123457','皮皮虾',3.20,1,'http://img54.foodjx.com/9/20160524/635996785462944459462.jpg','2017-10-14 04:56:18','2017-10-18 14:40:13'),('1508436760204445358','1508436760192978833','1234568','芒果冰',20.00,1,'http://rj2.douguo.net/upload/diet/c/a/0/ca6a486178a29c2951d7f8d52eaebed0.jpg','2017-10-14 04:56:18','2017-10-18 15:02:03'),('1508437226829283872','1508437226810626215','0000003','皮蛋粥',3.10,1,'http://i3.meishichina.com/attachment/recipe/201001/201001032036581.JPG@!p800','2017-10-14 04:56:18','2017-10-19 18:08:57'),('1508437226858131390','1508437226810626215','123457','皮皮虾',3.20,1,'http://img54.foodjx.com/9/20160524/635996785462944459462.jpg','2017-10-14 04:56:18','2017-10-19 18:12:40'),('1508437570119831708','1508437570112689791','0000003','皮蛋粥',3.10,1,'http://i3.meishichina.com/attachment/recipe/201001/201001032036581.JPG@!p800','2017-10-14 04:56:18','2017-10-19 18:20:26'),('1508437570136530351','1508437570112689791','123457','皮皮虾',3.20,1,'http://img54.foodjx.com/9/20160524/635996785462944459462.jpg','2017-10-14 04:56:18','2017-10-19 18:20:26');
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_master`
--

DROP TABLE IF EXISTS `order_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_master` (
  `order_id` varchar(32) NOT NULL,
  `buyer_name` varchar(32) NOT NULL,
  `buyer_contact` varchar(32) NOT NULL,
  `order_amount` decimal(8,2) NOT NULL,
  `order_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '订单状态，默认0新下单',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `order_abstract` varchar(255) DEFAULT NULL COMMENT '订单摘要',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_master`
--

LOCK TABLES `order_master` WRITE;
/*!40000 ALTER TABLE `order_master` DISABLE KEYS */;
INSERT INTO `order_master` VALUES ('1508170317507262162','廖师兄','123456789012',26.40,0,'2017-10-16 16:11:57','2017-10-16 16:11:57',NULL),('1508436537137963462','王凡','15996262016',3.10,0,'2017-10-19 18:08:57','2017-10-19 18:08:57',NULL),('1508436760192978833','hhh','15666285944',23.20,0,'2017-10-19 18:12:40','2017-10-19 18:12:40',NULL),('1508437226810626215','王凡','15926484',6.30,0,'2017-10-19 18:20:26','2017-10-19 18:20:27',NULL),('1508437570112689791','王凡','15926484',6.30,0,'2017-10-19 18:26:10','2017-10-19 18:26:10',NULL);
/*!40000 ALTER TABLE `order_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES (1,'热销榜','2017-10-11 14:24:39','2017-10-11 14:24:39'),(2,'女生最爱','2017-10-11 14:26:45','2017-10-11 14:26:45');
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_info`
--

DROP TABLE IF EXISTS `product_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_info` (
  `product_id` varchar(32) NOT NULL,
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `name_abbr` varchar(45) DEFAULT NULL,
  `product_brand` varchar(45) DEFAULT NULL,
  `product_price` decimal(8,2) NOT NULL COMMENT '商品单价',
  `product_model` varchar(45) DEFAULT NULL COMMENT '型号',
  `product_size` varchar(45) DEFAULT NULL COMMENT '规格\n长*宽*高',
  `product_unit` varchar(45) DEFAULT NULL,
  `product_weight` int(11) DEFAULT NULL COMMENT '单位为克',
  `product_stock` int(11) NOT NULL COMMENT '商品库存',
  `product_description` varchar(64) DEFAULT NULL COMMENT '描述',
  `product_icon` varchar(512) DEFAULT NULL COMMENT '小图标',
  `product_status` tinyint(3) DEFAULT '0' COMMENT '商品状态\n0正常\n1下架',
  `category` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_info`
--

LOCK TABLES `product_info` WRITE;
/*!40000 ALTER TABLE `product_info` DISABLE KEYS */;
INSERT INTO `product_info` VALUES ('0000003','皮蛋粥',NULL,NULL,3.10,NULL,NULL,NULL,NULL,97,'很好喝的粥','http://i3.meishichina.com/attachment/recipe/201001/201001032036581.JPG@!p800',0,2,'2017-10-14 04:56:18','2017-10-19 18:26:10'),('1234568','芒果冰',NULL,NULL,20.00,NULL,NULL,NULL,NULL,198,'很好吃的冰','http://rj2.douguo.net/upload/diet/c/a/0/ca6a486178a29c2951d7f8d52eaebed0.jpg',0,3,'2017-10-14 04:56:18','2017-10-19 18:12:40'),('123457','皮皮虾',NULL,NULL,3.20,NULL,NULL,NULL,NULL,95,'很好吃的虾','http://img54.foodjx.com/9/20160524/635996785462944459462.jpg',0,2,'2017-10-14 04:56:18','2017-10-19 18:26:10');
/*!40000 ALTER TABLE `product_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_check`
--

DROP TABLE IF EXISTS `stock_check`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock_check` (
  `product_id` varchar(32) NOT NULL,
  `adjust_quantity` int(11) DEFAULT NULL,
  `adjust_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`,`adjust_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存盘点';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_check`
--

LOCK TABLES `stock_check` WRITE;
/*!40000 ALTER TABLE `stock_check` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_check` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_purchase`
--

DROP TABLE IF EXISTS `stock_purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock_purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` varchar(32) DEFAULT NULL,
  `product_unit` varchar(45) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `tax` double DEFAULT NULL,
  `comments` varchar(512) DEFAULT NULL,
  `master_id` int(11) NOT NULL,
  `seller` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_purchase`
--

LOCK TABLES `stock_purchase` WRITE;
/*!40000 ALTER TABLE `stock_purchase` DISABLE KEYS */;
INSERT INTO `stock_purchase` VALUES (1,'1231',NULL,2,20,0,5,'test2',1,'wf'),(2,NULL,NULL,NULL,0,0,0,NULL,1,NULL),(3,'123',NULL,2,20,0,5,'test1',2,'wf'),(4,'1231',NULL,2,20,0,5,'test2',2,'wf');
/*!40000 ALTER TABLE `stock_purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_purchase_master`
--

DROP TABLE IF EXISTS `stock_purchase_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock_purchase_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `comments` varchar(512) DEFAULT NULL,
  `seller` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_purchase_master`
--

LOCK TABLES `stock_purchase_master` WRITE;
/*!40000 ALTER TABLE `stock_purchase_master` DISABLE KEYS */;
INSERT INTO `stock_purchase_master` VALUES (1,NULL,'test',NULL),(2,'2019-04-14 07:48:53','test2',NULL);
/*!40000 ALTER TABLE `stock_purchase_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'ims'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-14 15:51:47
