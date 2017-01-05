/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost
 Source Database       : ssm2

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : utf-8

 Date: 01/05/2017 22:28:08 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `datasource`
-- ----------------------------
DROP TABLE IF EXISTS `datasource`;
CREATE TABLE `datasource` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) DEFAULT NULL COMMENT '聊天内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `datasource`
-- ----------------------------
BEGIN;
INSERT INTO `datasource` VALUES ('2', '<p>9090<br/></p>'), ('7', 'hah'), ('9', '<p>说的是都是<br/></p>'), ('10', '哈哈你说的是呢<br/>'), ('11', '<p>你说什么呢<br/></p>'), ('12', '<p>你好啊<img src=\"http://img.baidu.com/hi/jx2/j_0026.gif\"/><br/></p>'), ('13', '<p>nihao啊</p>'), ('14', '说的'), ('15', '哈哈哈哈<br/>'), ('16', '你在干甚呢<br/>'), ('17', '<p>搞好久</p>'), ('18', '<p>8989<br/></p>'), ('19', '9899'), ('20', '家哈哈哈'), ('21', '<p>说的是<br/></p>'), ('22', '<p>哈哈</p>'), ('23', '<p>你说什么<br/></p>'), ('24', '909'), ('25', '<p>你好<br/></p>'), ('26', '你在干嘛呢<br/>'), ('27', '<p>积极</p>'), ('28', '7878');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
