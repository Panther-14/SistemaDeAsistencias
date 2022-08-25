CREATE DATABASE  IF NOT EXISTS `sistemaasistencias` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sistemaasistencias`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: sistemaasistencias
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `asistencias`
--

DROP TABLE IF EXISTS `asistencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asistencias` (
  `idAsistencias` int NOT NULL AUTO_INCREMENT,
  `asistencia` int DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `nrc` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `matricula` varchar(9) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`idAsistencias`,`nrc`,`matricula`),
  KEY `fk_Asistencias_Experiencia Educativa1_idx` (`nrc`),
  KEY `fk_Asistencias_Estudiante1_idx` (`matricula`),
  CONSTRAINT `fk_Asistencias_Estudiante1` FOREIGN KEY (`matricula`) REFERENCES `estudiante` (`matricula`),
  CONSTRAINT `fk_Asistencias_Experiencia Educativa1` FOREIGN KEY (`nrc`) REFERENCES `experienciaeducativa` (`nrc`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistencias`
--

LOCK TABLES `asistencias` WRITE;
/*!40000 ALTER TABLE `asistencias` DISABLE KEYS */;
INSERT INTO `asistencias` VALUES (1,1,'2022-08-22','12355','s27576475');
/*!40000 ALTER TABLE `asistencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrera`
--

DROP TABLE IF EXISTS `carrera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrera` (
  `idCarrera` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`idCarrera`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrera`
--

LOCK TABLES `carrera` WRITE;
/*!40000 ALTER TABLE `carrera` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante` (
  `matricula` varchar(9) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nombre` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `apellidoPaterno` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `apellidoMaterno` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nombreUsuario` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`matricula`,`nombreUsuario`),
  KEY `fk_Estudiante_Usuario1_idx` (`nombreUsuario`),
  CONSTRAINT `fk_Estudiante_Usuario1` FOREIGN KEY (`nombreUsuario`) REFERENCES `usuario` (`nombreUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES ('s20015725','Kyle','Perez','Martinez','oarnhold5'),('s27576475','Doyle','Gerlts','Healey','dhealey4'),('s34093987','Danice','Wichard','Legen','dlegen2'),('s39392865','Ottilie','Haldon','Arnhold','oarnhold5'),('s52199398','Inger','Chasier','Fuentes','ifuentes0'),('s59423109','Nina','Lapere','Chatwin','nchatwin1'),('s90611166','Wye','Kanter','Cartmill','wcartmill3');
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiantecursaee`
--

DROP TABLE IF EXISTS `estudiantecursaee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiantecursaee` (
  `idCursa` int NOT NULL AUTO_INCREMENT,
  `nrc` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `matricula` varchar(9) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`idCursa`,`nrc`,`matricula`),
  KEY `fk_Experiencia Educativa_has_Estudiante_Estudiante1_idx` (`matricula`),
  KEY `fk_Experiencia Educativa_has_Estudiante_Experiencia Educati_idx` (`nrc`),
  CONSTRAINT `fk_Experiencia Educativa_has_Estudiante_Estudiante1` FOREIGN KEY (`matricula`) REFERENCES `estudiante` (`matricula`),
  CONSTRAINT `fk_Experiencia Educativa_has_Estudiante_Experiencia Educativa1` FOREIGN KEY (`nrc`) REFERENCES `experienciaeducativa` (`nrc`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiantecursaee`
--

LOCK TABLES `estudiantecursaee` WRITE;
/*!40000 ALTER TABLE `estudiantecursaee` DISABLE KEYS */;
INSERT INTO `estudiantecursaee` VALUES (6,'15093','s90611166'),(7,'15093','s39392865'),(8,'38162','s90611166'),(9,'74666','s90611166'),(3,'81709','s39392865'),(4,'81709','s52199398'),(2,'82050','s34093987'),(5,'82050','s59423109'),(1,'90275','s27576475');
/*!40000 ALTER TABLE `estudiantecursaee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experienciaeducativa`
--

DROP TABLE IF EXISTS `experienciaeducativa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `experienciaeducativa` (
  `nrc` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nombreEE` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activa` int DEFAULT NULL,
  `lunes` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `miercoles` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `martes` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `jueves` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `viernes` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sabado` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `domingo` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`nrc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experienciaeducativa`
--

LOCK TABLES `experienciaeducativa` WRITE;
/*!40000 ALTER TABLE `experienciaeducativa` DISABLE KEYS */;
INSERT INTO `experienciaeducativa` VALUES ('12355','Afrikaans',1,'4:08','22:02','17:18','7:26','15:25','18:36','20:02'),('15093','Tsonga',1,'14:00','10:46','2:51','6:03','1:22','11:50','2:23'),('36176','Aymara',0,'22:26','6:39','9:38','21:59','9:32','15:24','16:53'),('38162','Swahili',1,'23:15','18:07','8:05','4:33','14:07','0:00','3:51'),('53561','Kyrgyz',1,'7:24','3:43','5:09','16:49','11:51','0:44','22:09'),('71286','Greek',1,'14:00','21:53','12:16','4:16','6:14','23:20','11:04'),('74666','Burmese',1,'12:25','9:38','16:31','6:14','18:31','7:15','3:31'),('81709','Tswana',1,'6:58','9:52','5:42','18:41','9:17','17:55','6:45'),('82050','New Zealand Sign Language',1,'20:00','19:50','0:54','8:32','17:27','14:25','3:46'),('90275','Haitian Creole',1,'7:16','10:22','18:00','7:42','18:53','9:32','16:29');
/*!40000 ALTER TABLE `experienciaeducativa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experienciascarreras`
--

DROP TABLE IF EXISTS `experienciascarreras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `experienciascarreras` (
  `idCarreraEE` int NOT NULL AUTO_INCREMENT,
  `idCarrera` int NOT NULL,
  `nrc` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`idCarreraEE`,`idCarrera`,`nrc`),
  KEY `fk_CarreraEE_Experiencia Educativa1_idx` (`nrc`),
  KEY `fk_Carrera_Experiencia Educativa1_idx` (`idCarrera`),
  CONSTRAINT `fk_Carrera_Experiencia Educativa1` FOREIGN KEY (`idCarrera`) REFERENCES `carrera` (`idCarrera`),
  CONSTRAINT `fk_CarreraEE_Experiencia Educativa1` FOREIGN KEY (`nrc`) REFERENCES `experienciaeducativa` (`nrc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experienciascarreras`
--

LOCK TABLES `experienciascarreras` WRITE;
/*!40000 ALTER TABLE `experienciascarreras` DISABLE KEYS */;
/*!40000 ALTER TABLE `experienciascarreras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor` (
  `numeroEmpleado` int NOT NULL,
  `nombre` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `apellidoPaterno` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `apellidoMaterno` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nombreUsuario` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`numeroEmpleado`,`nombreUsuario`),
  KEY `fk_Profesor_Usuario1_idx` (`nombreUsuario`),
  CONSTRAINT `fk_Profesor_Usuario1` FOREIGN KEY (`nombreUsuario`) REFERENCES `usuario` (`nombreUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (0,'Juan','Perez','Marquez','Paul'),(1151,'Annabela','Burchfield','Millsap','gstollberg7'),(1412,'Cyrille','Aveyard','MacKee','khaymes5'),(1443,'Carry','Abramowsky','Guillotin','rzylberdik8'),(1818,'Reinald','Shenton','Parrish','acanario9');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesorimparteee`
--

DROP TABLE IF EXISTS `profesorimparteee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesorimparteee` (
  `idImparte` int NOT NULL AUTO_INCREMENT,
  `numeroEmpleado` int NOT NULL,
  `nrc` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`idImparte`,`numeroEmpleado`,`nrc`),
  KEY `fk_ProfesorEE_Profesor1_idx` (`numeroEmpleado`),
  KEY `fk_ProfesorImparteEE_Experiencia Educativa1_idx` (`nrc`),
  CONSTRAINT `fk_ProfesorEE_Profesor1` FOREIGN KEY (`numeroEmpleado`) REFERENCES `profesor` (`numeroEmpleado`),
  CONSTRAINT `fk_ProfesorImparteEE_Experiencia Educativa1` FOREIGN KEY (`nrc`) REFERENCES `experienciaeducativa` (`nrc`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesorimparteee`
--

LOCK TABLES `profesorimparteee` WRITE;
/*!40000 ALTER TABLE `profesorimparteee` DISABLE KEYS */;
INSERT INTO `profesorimparteee` VALUES (12,0,'12355'),(1,1151,'12355'),(2,1412,'15093'),(3,1443,'36176'),(4,1818,'81709');
/*!40000 ALTER TABLE `profesorimparteee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `idRol` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Profesor'),(2,'Estudiante');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `nombreUsuario` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `contrasenia` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `idRol` int NOT NULL,
  PRIMARY KEY (`nombreUsuario`,`idRol`),
  KEY `fk_Usuario_Rol_idx` (`idRol`),
  CONSTRAINT `fk_Usuario_Rol` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('acanario9','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2',1),('dhealey4','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2',2),('dlegen2','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2',2),('gstollberg7','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2',1),('ifuentes0','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2',2),('khaymes5','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2',1),('nchatwin1','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2',2),('oarnhold5','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2',2),('Paul','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2',1),('rzylberdik8','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2',1),('wcartmill3','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2',2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-24 21:00:32
