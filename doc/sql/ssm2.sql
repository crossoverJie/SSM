# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.16)
# Database: ssm2
# Generation Time: 2018-04-08 09:34:57 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table datasource
# ------------------------------------------------------------

DROP TABLE IF EXISTS `datasource`;

CREATE TABLE `datasource` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) DEFAULT NULL COMMENT '聊天内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `datasource` WRITE;
/*!40000 ALTER TABLE `datasource` DISABLE KEYS */;

INSERT INTO `datasource` (`id`, `name`)
VALUES
	(2,'<p>9090<br/></p>'),
	(7,'hah'),
	(9,'<p>说的是都是<br/></p>'),
	(10,'哈哈你说的是呢<br/>'),
	(11,'<p>你说什么呢<br/></p>'),
	(12,'<p>你好啊<img src=\"http://img.baidu.com/hi/jx2/j_0026.gif\"/><br/></p>'),
	(13,'<p>nihao啊</p>'),
	(14,'说的'),
	(15,'哈哈哈哈<br/>'),
	(16,'你在干甚呢<br/>'),
	(17,'<p>搞好久</p>'),
	(18,'<p>8989<br/></p>'),
	(19,'9899'),
	(20,'家哈哈哈'),
	(21,'<p>说的是<br/></p>'),
	(22,'<p>哈哈</p>'),
	(23,'<p>你说什么<br/></p>'),
	(24,'909'),
	(25,'<p>你好<br/></p>'),
	(26,'你在干嘛呢<br/>'),
	(27,'<p>积极</p>'),
	(28,'7878');

/*!40000 ALTER TABLE `datasource` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
