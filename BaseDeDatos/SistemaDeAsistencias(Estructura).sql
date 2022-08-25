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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-24 21:02:26
