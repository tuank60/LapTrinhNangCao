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
  `IDD` int(11) NOT NULL AUTO_INCREMENT,
  `KhachHang` int(11) NOT NULL,
  `TongTien` varchar(45) NOT NULL,
  `NgayBan` datetime NOT NULL,
  `BinhLuan` text NOT NULL,
  PRIMARY KEY (`IDD`),
  KEY `KhachHang_idx` (`KhachHang`),
  CONSTRAINT `KhachHang` FOREIGN KEY (`KhachHang`) REFERENCES `khachhang` (`IDKH`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donhang`
--

LOCK TABLES `donhang` WRITE;
/*!40000 ALTER TABLE `donhang` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,'TU1100','Do Anh Tuan','1997-11-14 00:00:00','0962199197','Ha Noi','doanhtuan14111997@gamil.com'),(2,'TO1230','Cao Dưc Toan ','1997-08-16 00:00:00','092414554','Thai Binh','caoductoan@gmail.com');
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
  `IDSP` int(11) NOT NULL,
  `MaSP` varchar(45) NOT NULL,
  `TenSP` varchar(45) NOT NULL,
  `HangSP` int(11) NOT NULL,
  `NSX` datetime NOT NULL,
  `GIaTien` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IDSP`),
  KEY `HangSP_idx` (`HangSP`),
  CONSTRAINT `HangSP` FOREIGN KEY (`HangSP`) REFERENCES `hangsp` (`IDHSP`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (1,'AD01','ULTRA BOOST',1,'2018-05-08 00:00:00','1500000'),(2,'AD02','YEEZY',1,'2018-12-26 00:00:00','1250000'),(3,'AD03','ADIDAS STANSMITH',1,'2016-11-14 00:00:00','2010000'),(4,'NK01','SB Portmore II',2,'2019-11-11 00:00:00','1100000'),(5,'PM01','Fenty Creeper',3,'2018-01-01 00:00:00','1230000'),(6,'PM06','Fenty P698',3,'2018-11-01 00:00:00','1450000');
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
  PRIMARY KEY (`IDM`),
  KEY `IDDonHang_idx` (`IDDonHang`),
  KEY `IDSanPham_idx` (`IDSanPham`),
  CONSTRAINT `IDDonHang` FOREIGN KEY (`IDDonHang`) REFERENCES `donhang` (`IDD`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `IDSanPham` FOREIGN KEY (`IDSanPham`) REFERENCES `sanpham` (`IDSP`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ttmua`
--

LOCK TABLES `ttmua` WRITE;
/*!40000 ALTER TABLE `ttmua` DISABLE KEYS */;
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

-- Dump completed on 2019-04-01 16:43:50
