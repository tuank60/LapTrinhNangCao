-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlybanhang
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `donhang`
--

DROP TABLE IF EXISTS `donhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `donhang` (
  `IDD` int(11) DEFAULT NULL,
  `MaDonHang` int(11) NOT NULL AUTO_INCREMENT,
  `TongTien` varchar(45) NOT NULL,
  `NgayBan` datetime NOT NULL,
  `BinhLuan` text NOT NULL,
  `IDQuanLy` int(11) NOT NULL,
  `MaKhachHang` varchar(45) NOT NULL,
  PRIMARY KEY (`MaDonHang`),
  KEY `IDQuanLy_idx` (`IDQuanLy`),
  CONSTRAINT `IDQuanLy` FOREIGN KEY (`IDQuanLy`) REFERENCES `quanly` (`IDQL`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donhang`
--

LOCK TABLES `donhang` WRITE;
/*!40000 ALTER TABLE `donhang` DISABLE KEYS */;
INSERT INTO `donhang` VALUES (1,1,'1200000','2018-02-01 00:00:00','okok',1,'1'),(2,2,'4333333','2019-11-01 00:00:00','yes',1,'1'),(3,3,'4250000','2019-05-19 00:00:00','yes',1,'T1'),(NULL,4,'2010000','2019-05-20 00:00:00','yes',1,'T1'),(NULL,5,'7530000','2019-05-20 00:00:00','yes',1,'T1');
/*!40000 ALTER TABLE `donhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hangsp`
--

DROP TABLE IF EXISTS `hangsp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hangsp` (
  `IDHSP` int(11) NOT NULL AUTO_INCREMENT,
  `TenHSP` varchar(45) NOT NULL,
  `SDT` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `DiaChi` text NOT NULL,
  PRIMARY KEY (`IDHSP`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hangsp`
--

LOCK TABLES `hangsp` WRITE;
/*!40000 ALTER TABLE `hangsp` DISABLE KEYS */;
INSERT INTO `hangsp` VALUES (1,'Adidas','0433788123','adidas@gmail.com','Germany'),(2,'Nike','033788678','nike@Gmail.com','USA'),(3,'Puma','033123987','puma@gmail.com','Germany');
/*!40000 ALTER TABLE `hangsp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `khachhang` (
  `IDKH` int(11) NOT NULL AUTO_INCREMENT,
  `MaKH` varchar(45) NOT NULL,
  `TenKH` varchar(45) DEFAULT NULL,
  `NgaySinh` datetime NOT NULL,
  `SDT` varchar(45) NOT NULL,
  `QueQuan` text,
  `Email` varchar(45) NOT NULL,
  PRIMARY KEY (`IDKH`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 PACK_KEYS=1 DELAY_KEY_WRITE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,'T1','Do Anh Tuan','1997-11-14 00:00:00','0962199197','Ha Noi','doanhtuan14111997@gmail.com'),(2,'T2','Cao Duc Toan','1997-05-06 00:00:00','0912343233','Thai Binh','caotoan@gamil.com'),(4,'T5','Hai','1997-11-04 00:00:00','0991123434','Nghe An','haia@gmail.com'),(7,'T6','v','1997-11-04 00:00:00','0999','hhhhh','ghjgj'),(8,'T9','1','1997-01-01 00:00:00','00','fds','sdfs'),(9,'1','1','2019-04-05 00:00:00','1','1','1');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quanly`
--

DROP TABLE IF EXISTS `quanly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quanly` (
  `IDQL` int(11) NOT NULL,
  `TenQL` varchar(45) NOT NULL,
  `GioiTinh` varchar(45) NOT NULL,
  `NgaySinh` datetime NOT NULL,
  `QueQuan` text,
  `SDT` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `TaiKhoan` varchar(45) NOT NULL,
  `MatKhau` varchar(45) NOT NULL,
  PRIMARY KEY (`IDQL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quanly`
--

LOCK TABLES `quanly` WRITE;
/*!40000 ALTER TABLE `quanly` DISABLE KEYS */;
INSERT INTO `quanly` VALUES (1,'Tuan','Nam','1997-11-14 00:00:00','HaNoi','092199197','daanhtuan14111997@gamil.com','admin','admin');
/*!40000 ALTER TABLE `quanly` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sanpham` (
  `IDSP` int(11) NOT NULL AUTO_INCREMENT,
  `MaSP` varchar(45) NOT NULL,
  `TenSP` varchar(45) NOT NULL,
  `HangSP` int(11) NOT NULL,
  `NSX` datetime NOT NULL,
  `GIaTien` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDSP`),
  KEY `HangSP_idx` (`HangSP`),
  CONSTRAINT `HangSP` FOREIGN KEY (`HangSP`) REFERENCES `hangsp` (`IDHSP`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (1,'AD01','ULTRA BOOST',1,'2018-05-08 00:00:00',1500000),(2,'AD02','YEEZY',1,'2018-12-26 00:00:00',1250000),(3,'AD03','ADIDAS STANSMITH',1,'2016-11-14 00:00:00',2010000),(4,'NK01','SB Portmore II',2,'2019-11-11 00:00:00',1100000),(5,'PM01','Fenty Creeper',3,'2018-01-01 00:00:00',1230000),(6,'PM06','Fenty P698',3,'2018-11-01 00:00:00',1450000),(7,'AD123','AD',1,'2019-04-09 00:00:00',12333333);
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ttmua`
--

DROP TABLE IF EXISTS `ttmua`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ttmua` (
  `IDM` int(11) NOT NULL AUTO_INCREMENT,
  `IDDonHang` int(11) NOT NULL,
  `IDSanPham` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `TenSanPham` varchar(45) DEFAULT NULL,
  `GiaTien1SanPham` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDM`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ttmua`
--

LOCK TABLES `ttmua` WRITE;
/*!40000 ALTER TABLE `ttmua` DISABLE KEYS */;
INSERT INTO `ttmua` VALUES (1,1,2,5,'100000',111111);
/*!40000 ALTER TABLE `ttmua` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-26 20:24:31
