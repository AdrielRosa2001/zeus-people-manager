CREATE DATABASE  IF NOT EXISTS `zeusdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `zeusdb`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: zeusdb
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `id_pessoa` int unsigned DEFAULT NULL,
  `matricula` varchar(45) NOT NULL,
  `mensalidade` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_pessoa_aluno` (`id_pessoa`),
  CONSTRAINT `fk_pessoa_aluno` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (8,20,'46546343',200),(9,21,'46546343',200),(10,23,'46546343',200);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pessoa` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `usuario` varchar(44) NOT NULL,
  `senha` varchar(44) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `data_nascimento` varchar(10) DEFAULT NULL,
  `idade` int unsigned NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `email` varchar(45) NOT NULL,
  `endereco` varchar(80) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `nivel_de_acesso` int unsigned NOT NULL,
  `status_da_conta` int unsigned NOT NULL,
  `pgt_rec_senha` varchar(150) NOT NULL,
  `resp_rec_senha` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (9,'admin','admin','ADRIEL ROSA DA SILVA','14/04/2001',40,'234.321.235-77','exemplo@gmail.com','av mar do norte','(84) 9 8881-2222',3,1,'Onde seus pais se conhecera?','natal'),(20,'rafaelcosta','123456','RAFAEL GOMES COSTA','28/06/1998',40,'187.785.135-22','rafaelcosta@gmail.com','Rua dos guarapes, n 27','(84) 9 8872-6352',1,1,'Onde seus pais se conhecera?','Mossoro'),(21,'natanaelsilva','123456','NATANAEL SILVA DA COSTA','02/11/2002',40,'128.786.135-23','natanael_bolado@hotmail.com','Av mar do oeste, n33','(84) 9 8872-3542',1,1,'Qual é a sua comida favorita?','pizza'),(22,'carlosroberto','123456','CARLOS ROBERTO DA CUNHA','02/12/1967',40,'178.765.123-11','carlosrobertopereira@yahoo.com','Av cap. mor golveia, n 1123','(84) 9 8812-3451',2,1,'Em que cidade você nasceu?','natal'),(23,'fernandofagundes','123456','FERNANDO FAGUNDES FARIAS FILHO','28/03/2001',40,'245.123.451-12','fagundesfarias@bol.com','rua da carpa, n 44','(84) 9 8856-3356',1,1,'Qual é o nome do seu primeiro animal de estimação?','dexter'),(34,'renatapereira','123456','RENATA PEREIRA DOS SANTOS','04/06/1978',45,'793.927.744-86','renatapereira@bol.com','2ª Travessa Paiatis','(84) 9 8889-8723',2,1,'Onde seus pais se conhecera?','Mossoro'),(35,'hideljundesmacedo','123456','HIDELJUNDES MACEDO PAULINO','27/04/1973',50,'591.011.744-01','hideljundesmacedo@hotmail.com','natal rn','(84) 9 9877-6543',2,1,'Qual é a sua comida favorita?','morango'),(36,'glaubergalvao','123456','Glauber Galvao de Araujo','17/09/1967',55,'038.403.064-50','glaubergalvao@gmail.com','natal','(84) 9 9130-5608',2,1,'Em que cidade você nasceu?','natal');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professor` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `id_pessoa` int unsigned DEFAULT NULL,
  `materia_lecionada` varchar(45) NOT NULL DEFAULT '',
  `salario` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_pessoa_professor` (`id_pessoa`),
  CONSTRAINT `fk_pessoa_professor` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES (5,9,'Programação Estruturada',3000.5),(9,22,'Portugues',5000),(12,34,'Portugues',3500),(13,35,'Portugues',10000),(14,36,'Portugues',100000);
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-17 17:21:53
