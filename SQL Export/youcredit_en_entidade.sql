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
-- Table structure for table `en_entidade`
--

DROP TABLE IF EXISTS `en_entidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `en_entidade` (
  `entidade_id` int NOT NULL AUTO_INCREMENT,
  `entidade` varchar(25) NOT NULL,
  `nome` varchar(75) NOT NULL,
  `nif` varchar(10) DEFAULT NULL,
  `cartao_cidadao` varchar(15) DEFAULT NULL,
  `passaporte` varchar(15) DEFAULT NULL,
  `morada` varchar(100) NOT NULL,
  `codigo_postal` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `data_nascimento` date NOT NULL,
  `genero` varchar(10) NOT NULL,
  `entidade_empregadora` varchar(50) DEFAULT NULL,
  `data_inicio_emprego` date DEFAULT NULL,
  `rating` int NOT NULL,
  `salario_anual` decimal(9,2) NOT NULL,
  `creditos_actuais` decimal(9,2) NOT NULL,
  `lista_negra` varchar(75) DEFAULT NULL,
  `sector_actividade_id` int NOT NULL,
  `situacao_profissional_id` int NOT NULL,
  `segmento_cliente_id` int NOT NULL,
  `estado_entidade_id` int NOT NULL,
  `nacionalidade_id` int NOT NULL,
  `data_estado_entidade` date DEFAULT NULL,
  `existe_crm` varchar(1) DEFAULT NULL,
  `data_log` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utilizador_log` int NOT NULL,
  `estado_log` varchar(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`entidade_id`),
  KEY `sector_actividade_id` (`sector_actividade_id`),
  KEY `situacao_profissional_id` (`situacao_profissional_id`),
  KEY `estado_entidade_id` (`estado_entidade_id`),
  KEY `segmento_cliente_id` (`segmento_cliente_id`),
  KEY `nacionalidade_id` (`nacionalidade_id`),
  CONSTRAINT `en_entidade_ibfk_1` FOREIGN KEY (`sector_actividade_id`) REFERENCES `en_sector_actividade` (`sector_actividade_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `en_entidade_ibfk_2` FOREIGN KEY (`situacao_profissional_id`) REFERENCES `en_situacao_profissional` (`situacao_profissional_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `en_entidade_ibfk_3` FOREIGN KEY (`estado_entidade_id`) REFERENCES `en_estado_entidade` (`estado_entidade_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `en_entidade_ibfk_4` FOREIGN KEY (`segmento_cliente_id`) REFERENCES `en_segmento_cliente` (`segmento_cliente_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `en_entidade_ibfk_5` FOREIGN KEY (`nacionalidade_id`) REFERENCES `en_nacionalidade` (`nacionalidade_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `en_entidade_chk_estadolog` CHECK (((`estado_log` = _utf8mb4'A') or (`estado_log` = _utf8mb4'I'))),
  CONSTRAINT `en_entidade_chk_genero` CHECK (((`genero` = _utf8mb4'Masculino') or (`genero` = _utf8mb4'Feminino') or (`genero` = _utf8mb4'Neutro')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `en_entidade`
--

LOCK TABLES `en_entidade` WRITE;
/*!40000 ALTER TABLE `en_entidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `en_entidade` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-14 21:03:19
