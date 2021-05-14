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
-- Table structure for table `cr_simulacao_credito`
--

DROP TABLE IF EXISTS `cr_simulacao_credito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cr_simulacao_credito` (
  `simulacao_id` int NOT NULL AUTO_INCREMENT,
  `referencia` varchar(50) DEFAULT NULL,
  `flag_credito` tinyint(1) NOT NULL,
  `data_solicitacao` date DEFAULT NULL,
  `data_decisao` date DEFAULT NULL,
  `data_inicio` date NOT NULL,
  `data_fim` date DEFAULT NULL,
  `data_avaliacao` date DEFAULT NULL,
  `data_alteracao_estado_credito` date DEFAULT NULL,
  `total_solicitado` double NOT NULL,
  `total_concedido` double DEFAULT NULL,
  `total_possivel` double NOT NULL,
  `total_capital` double DEFAULT NULL,
  `total_juro` double NOT NULL,
  `total_despesa` double NOT NULL,
  `total_imposto` double NOT NULL,
  `descricao_objeto` varchar(50) DEFAULT NULL,
  `duracao` int DEFAULT NULL,
  `scoring` int NOT NULL,
  `data_alteracao_estado_simulacao` date NOT NULL,
  `parecer` tinyint(1) NOT NULL,
  `estado_id` int DEFAULT NULL,
  `periodicidade_id` int DEFAULT NULL,
  `produto_id` int DEFAULT NULL,
  `entidade_id` int DEFAULT NULL,
  `entidadeavalista` varchar(50) DEFAULT NULL,
  `existe_crm` varchar(1) DEFAULT NULL,
  `data_log` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utilizador_log` int NOT NULL,
  `estado_log` varchar(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`simulacao_id`),
  KEY `estado_id` (`estado_id`),
  KEY `periodicidade_id` (`periodicidade_id`),
  KEY `produto_id` (`produto_id`),
  KEY `entidade_id` (`entidade_id`),
  CONSTRAINT `cr_simulacao_credito_ibfk_1` FOREIGN KEY (`estado_id`) REFERENCES `cr_estado_credito_simulacao` (`estado_id`),
  CONSTRAINT `cr_simulacao_credito_ibfk_2` FOREIGN KEY (`periodicidade_id`) REFERENCES `cr_periodicidade_estado_prestacao` (`periodicidade_id`),
  CONSTRAINT `cr_simulacao_credito_ibfk_3` FOREIGN KEY (`produto_id`) REFERENCES `pr_produto` (`produto_id`),
  CONSTRAINT `cr_simulacao_credito_ibfk_4` FOREIGN KEY (`entidade_id`) REFERENCES `en_entidade` (`entidade_id`),
  CONSTRAINT `cr_simulacao_credito_chk_estadolog` CHECK (((`estado_log` = _utf8mb4'A') or (`estado_log` = _utf8mb4'I')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cr_simulacao_credito`
--

LOCK TABLES `cr_simulacao_credito` WRITE;
/*!40000 ALTER TABLE `cr_simulacao_credito` DISABLE KEYS */;
/*!40000 ALTER TABLE `cr_simulacao_credito` ENABLE KEYS */;
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
