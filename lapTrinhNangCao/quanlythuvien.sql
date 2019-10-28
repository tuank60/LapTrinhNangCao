CREATE DATABASE  IF NOT EXISTS `quanlythuvien` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `quanlythuvien`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlythuvien
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ctmuontra`
--

DROP TABLE IF EXISTS `ctmuontra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ctmuontra` (
  `mactmt` int(15) NOT NULL,
  `masach` int(15) NOT NULL,
  `ngaymuon` date NOT NULL,
  `hantra` date NOT NULL,
  `ngaytra` date DEFAULT NULL,
  `tienphat` int(11) DEFAULT NULL,
  `tinhtrang` varchar(45) NOT NULL,
  `ghichu` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`masach`,`mactmt`),
  KEY `fk_ctmuontra_ttmuontra1_idx` (`mactmt`),
  CONSTRAINT `fk_ctmuontra_sach1` FOREIGN KEY (`masach`) REFERENCES `sach` (`masach`),
  CONSTRAINT `fk_ctmuontra_ttmuontra1` FOREIGN KEY (`mactmt`) REFERENCES `ttmuontra` (`mamuontra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctmuontra`
--

LOCK TABLES `ctmuontra` WRITE;
/*!40000 ALTER TABLE `ctmuontra` DISABLE KEYS */;
INSERT INTO `ctmuontra` VALUES (20149515,1,'2018-12-23','2018-12-31','2018-12-23',0,'Đã trả',''),(20149515,2,'2018-12-23','2018-12-28','2018-12-23',0,'Đã trả','aaa'),(20149515,3,'2018-12-23','2019-01-30','2018-12-23',10000,'Đã trả','lam rach sach'),(20149516,4,'2018-12-23','2018-12-27',NULL,0,'Chưa trả',''),(20149516,5,'2018-12-23','2018-12-31',NULL,0,'Chưa trả',''),(20149525,8,'2018-12-23','2019-02-14',NULL,0,'Chưa trả',''),(20149525,9,'2018-12-23','2019-01-16',NULL,0,'Chưa trả',''),(20149525,13,'2018-12-23','2018-12-22',NULL,0,'Chưa trả',''),(20149525,17,'2018-12-23','2018-12-14',NULL,0,'Chưa trả','');
/*!40000 ALTER TABLE `ctmuontra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `dg_sach_ctmt_view`
--

DROP TABLE IF EXISTS `dg_sach_ctmt_view`;
/*!50001 DROP VIEW IF EXISTS `dg_sach_ctmt_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `dg_sach_ctmt_view` AS SELECT 
 1 AS `mactmt`,
 1 AS `masach`,
 1 AS `tensach`,
 1 AS `ngaymuon`,
 1 AS `hantra`,
 1 AS `ngaytra`,
 1 AS `tienphat`,
 1 AS `tinhtrang`,
 1 AS `ghichu`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `dg_ttmt_view`
--

DROP TABLE IF EXISTS `dg_ttmt_view`;
/*!50001 DROP VIEW IF EXISTS `dg_ttmt_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `dg_ttmt_view` AS SELECT 
 1 AS `mamuontra`,
 1 AS `tendocgia`,
 1 AS `datcoc`,
 1 AS `soluongchuatra`,
 1 AS `tienphat`,
 1 AS `ghichu`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `docgia`
--

DROP TABLE IF EXISTS `docgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `docgia` (
  `madocgia` int(15) NOT NULL,
  `tendocgia` varchar(200) NOT NULL,
  `ngaysinh` date NOT NULL,
  `lop` varchar(100) DEFAULT NULL,
  `dienthoai` int(15) NOT NULL,
  `quequan` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`madocgia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docgia`
--

LOCK TABLES `docgia` WRITE;
/*!40000 ALTER TABLE `docgia` DISABLE KEYS */;
INSERT INTO `docgia` VALUES (20149515,'Hóa Văn Bạo','2018-11-13','Kỹ thuật vật liệu 01',974880788,'Việt Yên - Bắc Giang'),(20149516,'Hoàng Thành Công','1996-02-27','Kỹ thuật vật liệu 02',983888611,'Sông Thao - Phú Thọ'),(20149525,'Trần Đức Long','1995-10-04','CTM1',986375176,'Cô Tô - Quảng Ninh'),(20149527,'Nguyễn Xuân Mạnh','1996-02-19','CTM2',914770545,'Việt Trì - Phú Thọ'),(20149528,'Nguyễn Bá Năm','1996-11-11','Kỹ thuật hóa học 1',986253482,'Lục Nam - Bắc Giang'),(20149529,'Đào Minh Ngoan','1994-08-22','Kỹ thuật hóa học 1',944545232,'Yên Phong - Bắc Ninh'),(20149531,'Mai Văn Phương','1997-05-05','Công nghệ thực phẩm 1',912644784,'Khoái Châu - Hưng Yên'),(20149532,'Trương Quốc Tài','1998-02-10','Công nghệ thực phẩm 5',1668890843,'Tiên Du - Bắc Ninh'),(20149533,'Nguyễn Văn Thế','1996-08-08','Kỹ thuật in và truyền thông 1',1634229954,'Đông Hưng - Thái Bình'),(20149534,'Nguyễn Văn Tuấn','1997-03-20','Dệt may và da dày ',966219941,'Vũ Thư - Thái Bình'),(20149538,'Mai Thị Yến','1996-10-22','Tự động hóa 01',1672377922,'Yên Khánh - Ninh Bình'),(20149880,'Phạm Vũ Linh','1995-09-23','CTM 1',984603663,'Tam Đảo - Vĩnh Phúc'),(20164932,'Nguyễn Văn An','1997-02-02','Cơ điện tử 03',982527982,'Ba Vì - Hà Nội'),(20165796,'Nguyễn Tiến Bình','1997-12-28','Cơ điện tử 03',973776072,'Yên Trung - Hà Nội'),(20165856,'Nguyễn Văn Diện','1998-04-19','Cơ điện tử 05',917749254,'Lại Xuân - Hải Phòng'),(20165903,'Ngô Văn Duy','1998-09-01','CNTT2.03',974880788,'Vạn Phái - Thái Nguyên'),(20165936,'Bùi Hải Đăng','1998-02-10','CNTT1.01',983888611,'Chu Hóa - Phú Thọ'),(20165938,'Nguyễn Khắc Dự','1998-05-29','Điện tử 08',904770053,'Lạng Giang - Bắc Giang');
/*!40000 ALTER TABLE `docgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sach`
--

DROP TABLE IF EXISTS `sach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sach` (
  `masach` int(15) NOT NULL AUTO_INCREMENT,
  `tensach` varchar(200) NOT NULL,
  `theloai` varchar(200) DEFAULT NULL,
  `tacgia` varchar(200) NOT NULL,
  `nhaxuatban` varchar(200) DEFAULT NULL,
  `namxuatban` int(11) DEFAULT NULL,
  `giatien` int(11) NOT NULL,
  PRIMARY KEY (`masach`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sach`
--

LOCK TABLES `sach` WRITE;
/*!40000 ALTER TABLE `sach` DISABLE KEYS */;
INSERT INTO `sach` VALUES (1,'Vang Bóng Một Thời','Truyện ngắn','Nguyễn Tuân','Hội nhà văn',2010,52500),(2,'Gấu à cậu ổn chứ?','Truyện tranh thiếu nhi','Jungmin Kim ','Thế Giới',2017,40000),(3,'Để con được ốm','Y học và sức khỏe',' Nguyễn Trí Đoàn - Uyên Bùi',' Thế Giới',2017,76000),(4,'Để yên cho bác sĩ \"hiền\"','Tự truyện',' BS. Ngô Đức Hùng',' Thế Giới',2017,60000),(5,'Vi tính thật là đơn giản tập 1','Khoa học công nghệ','ThS. Dương Mạnh Hùng','Văn hóa TT',2004,26000),(6,'Kỹ thuật điện tử số','Khoa học công nghệ','KS.Đỗ Thanh Hải','Thanh niên',1998,35000),(7,'Tập bài giảng Tin học văn phòng','Khoa học công nghệ','KS. Trần Ngọc Bích','Văn hóa TT',2007,25000),(8,'Mạng máy tính Tập 1','Khoa học công nghệ','Tống Văn On','Thống kê',2004,39500),(9,'Lập trình LINUX','Khoa học công nghệ','Phạm Hữu Khang','Lao động - Xã hội',2005,23000),(10,'Cấu trúc máy vi tính','Khoa học công nghệ','Trần Quang Vinh',' Giáo dục',2004,21000),(11,'Tin học đại cương','Khoa học công nghệ','PGS.TS Bùi Thế Tâm','Giao thông vận tải',2003,89000),(12,'Internet - Những địa chỉ bạn cần biết','Khoa học công nghệ','PGS.TS Bùi Thế Tâm','Thống kê',2004,55000),(13,'Kỹ xảo lập trình VB6','Khoa học công nghệ','Phạm Hữu Khang','Lao động - XH',2006,89000),(14,'Ngôn ngữ lập trình C','Khoa học công nghệ','Quách Tuấn Ngọc',' Giáo dục',1998,87000),(15,'Sử dụng Autocad 13','Khoa học công nghệ','TS. Nguyễn Hữu Lộc',' TP HCM',2014,56000),(16,'Giáo trình Kỹ thuật lắp đặt điện','Khoa học công nghệ','KS. Công Thọ',' Thời đại',1994,65000),(17,'Giáo trình An toàn điện','Khoa học công nghệ','Nguyễn Trường Sinh','Giáo dục VN',2004,89000),(18,'Tiếng chim hót trong bụi mận gai','Văn học','Nguyễn Văn Ba','NXB Văn học',2004,85000),(19,'Harry Potter và chiếc cốc lửa','Văn học','Phương Lan','NXB Trẻ',2005,75000),(20,'Miếng da lừa','Văn học',' Đinh Xuân Lâm','NXB Văn học',2005,43000),(21,'Vết sẹo và cái đầu hói','Văn học','TS. Trần Thủy Bình','NXB Hội nhà văn',2010,58000);
/*!40000 ALTER TABLE `sach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thuthu`
--

DROP TABLE IF EXISTS `thuthu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `thuthu` (
  `tendangnhap` varchar(45) NOT NULL,
  `matkhau` varchar(45) NOT NULL,
  `hovaten` varchar(45) DEFAULT NULL,
  `gioitinh` varchar(45) DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `quequan` varchar(45) DEFAULT NULL,
  `cmnd` int(11) DEFAULT NULL,
  `sodienthoai` int(11) DEFAULT NULL,
  PRIMARY KEY (`tendangnhap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thuthu`
--

LOCK TABLES `thuthu` WRITE;
/*!40000 ALTER TABLE `thuthu` DISABLE KEYS */;
INSERT INTO `thuthu` VALUES ('admin','admin123','Quan Tri Vien','Nam','1990-01-01','Hà Nội, Việt Nam',152067379,589201293);
/*!40000 ALTER TABLE `thuthu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ttmuontra`
--

DROP TABLE IF EXISTS `ttmuontra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ttmuontra` (
  `mamuontra` int(15) NOT NULL,
  `datcoc` int(11) NOT NULL,
  `soluongchuatra` int(11) DEFAULT NULL,
  `tienphat` int(11) DEFAULT NULL,
  `ghichu` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`mamuontra`),
  CONSTRAINT `fk_ttmuontra_docgia` FOREIGN KEY (`mamuontra`) REFERENCES `docgia` (`madocgia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ttmuontra`
--

LOCK TABLES `ttmuontra` WRITE;
/*!40000 ALTER TABLE `ttmuontra` DISABLE KEYS */;
INSERT INTO `ttmuontra` VALUES (20149515,0,0,10000,''),(20149516,21500,2,0,''),(20149525,60125,4,0,'');
/*!40000 ALTER TABLE `ttmuontra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `dg_sach_ctmt_view`
--

/*!50001 DROP VIEW IF EXISTS `dg_sach_ctmt_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `dg_sach_ctmt_view` AS select `ctmt`.`mactmt` AS `mactmt`,`s`.`masach` AS `masach`,`s`.`tensach` AS `tensach`,`ctmt`.`ngaymuon` AS `ngaymuon`,`ctmt`.`hantra` AS `hantra`,`ctmt`.`ngaytra` AS `ngaytra`,`ctmt`.`tienphat` AS `tienphat`,`ctmt`.`tinhtrang` AS `tinhtrang`,`ctmt`.`ghichu` AS `ghichu` from ((`ctmuontra` `ctmt` join `sach` `s` on((`ctmt`.`masach` = `s`.`masach`))) join `ttmuontra` `ttmt` on((`ctmt`.`mactmt` = `ttmt`.`mamuontra`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `dg_ttmt_view`
--

/*!50001 DROP VIEW IF EXISTS `dg_ttmt_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `dg_ttmt_view` AS select `ttmt`.`mamuontra` AS `mamuontra`,`dg`.`tendocgia` AS `tendocgia`,`ttmt`.`datcoc` AS `datcoc`,`ttmt`.`soluongchuatra` AS `soluongchuatra`,`ttmt`.`tienphat` AS `tienphat`,`ttmt`.`ghichu` AS `ghichu` from (`docgia` `dg` join `ttmuontra` `ttmt` on((`dg`.`madocgia` = `ttmt`.`mamuontra`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-23 20:01:47
