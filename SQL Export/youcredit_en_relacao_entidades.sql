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
-- Table structure for table `en_relacao_entidades`
--

DROP TABLE IF EXISTS `en_relacao_entidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `en_relacao_entidades` (
  `relacao_entidades_id` int NOT NULL AUTO_INCREMENT,
  `entidade_pai_id` int NOT NULL,
  `entidade_filho_id` int NOT NULL,
  `tipo_relacao_entidade_id` int NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `data_log` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utilizador_log` int NOT NULL,
  `estado_log` varchar(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`relacao_entidades_id`),
  KEY `entidade_pai_id` (`entidade_pai_id`),
  KEY `entidade_filho_id` (`entidade_filho_id`),
  KEY `tipo_relacao_entidade_id` (`tipo_relacao_entidade_id`),
  CONSTRAINT `en_relacao_entidades_ibfk_1` FOREIGN KEY (`entidade_pai_id`) REFERENCES `en_entidade` (`entidade_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `en_relacao_entidades_ibfk_2` FOREIGN KEY (`entidade_filho_id`) REFERENCES `en_entidade` (`entidade_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `en_relacao_entidades_ibfk_3` FOREIGN KEY (`tipo_relacao_entidade_id`) REFERENCES `en_tipo_relacao_entidade` (`tipo_relacao_entidade_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `en_relacaoentidades_chk_estadolog` CHECK (((`estado_log` = _utf8mb4'A') or (`estado_log` = _utf8mb4'I')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `en_relacao_entidades`
--

LOCK TABLES `en_relacao_entidades` WRITE;
/*!40000 ALTER TABLE `en_relacao_entidades` DISABLE KEYS */;
/*!40000 ALTER TABLE `en_relacao_entidades` ENABLE KEYS */;
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
