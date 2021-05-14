-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: youcredit
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `cr_estado_credito_simulacao`
--

DROP TABLE IF EXISTS `cr_estado_credito_simulacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cr_estado_credito_simulacao` (
  `estado_id` int NOT NULL AUTO_INCREMENT,
  `estado_simulacao` varchar(15) NOT NULL,
  `descricao` varchar(15) NOT NULL,
  `data_log` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utilizador_log` int NOT NULL,
  `estado_log` varchar(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`estado_id`),
  CONSTRAINT `cr_estado_credito_simulacao_chk_estadolog` CHECK (((`estado_log` = _utf8mb4'A') or (`estado_log` = _utf8mb4'I')))
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cr_estado_credito_simulacao`
--

LOCK TABLES `cr_estado_credito_simulacao` WRITE;
/*!40000 ALTER TABLE `cr_estado_credito_simulacao` DISABLE KEYS */;
INSERT INTO `cr_estado_credito_simulacao` VALUES (1,'Registado','Registado','2021-05-14 19:59:45',0,'A'),(2,'Para Aprovação','Para Aprovação','2021-05-14 19:59:45',0,'A'),(3,'Sem Efeito','Sem Efeito','2021-05-14 19:59:45',0,'A'),(4,'Aprovado','Aprovado','2021-05-14 19:59:45',0,'A'),(5,'Não Aprovado','Não Aprovado','2021-05-14 19:59:45',0,'A'),(6,'Sem Interesse','Sem Interesse','2021-05-14 19:59:45',0,'A');
/*!40000 ALTER TABLE `cr_estado_credito_simulacao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-14 21:03:20
