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
-- Table structure for table `pr_produto`
--

DROP TABLE IF EXISTS `pr_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pr_produto` (
  `produto_id` int NOT NULL AUTO_INCREMENT,
  `produto` varchar(15) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `instituicao_credito_id` int NOT NULL,
  `tempo_decisao` int NOT NULL,
  `limite_maximo` decimal(9,2) NOT NULL,
  `limite_minimo` decimal(9,2) NOT NULL,
  `taxa_juro` decimal(5,2) NOT NULL,
  `taxa_imposto_contratacao` decimal(5,2) NOT NULL,
  `taxa_despesa_contratacao` decimal(5,2) NOT NULL,
  `taxa_imposto_cobranca` decimal(5,2) NOT NULL,
  `taxa_despesa_cobranca` decimal(5,2) NOT NULL,
  `data_inicio` date NOT NULL,
  `data_fim` date DEFAULT NULL,
  `estado_produto_id` int NOT NULL,
  `data_estado_produto` date DEFAULT NULL,
  `data_log` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utilizador_log` int NOT NULL,
  `estado_log` varchar(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`produto_id`),
  KEY `instituicao_credito_id` (`instituicao_credito_id`),
  KEY `estado_produto_id` (`estado_produto_id`),
  CONSTRAINT `pr_produto_ibfk_1` FOREIGN KEY (`instituicao_credito_id`) REFERENCES `pr_instituicao_credito` (`instituicao_credito_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `pr_produto_ibfk_2` FOREIGN KEY (`estado_produto_id`) REFERENCES `pr_estado_produto` (`estado_produto_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `pr_produto_chk_estadolog` CHECK (((`estado_log` = _utf8mb4'A') or (`estado_log` = _utf8mb4'I')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pr_produto`
--

LOCK TABLES `pr_produto` WRITE;
/*!40000 ALTER TABLE `pr_produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `pr_produto` ENABLE KEYS */;
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
