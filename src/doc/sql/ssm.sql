/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50629
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2016-06-23 15:11:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/**
插入user数据
**/
insert into user values(NULL,'jack','abc123');
insert into user values(NULL,'zhangsan','abc123');
insert into user values(NULL,'lisi','abc123');
insert into user values(NULL,'wangwu','abc123');
insert into user values(NULL,'xiaolong','abc123');

-- ----------------------------
-- Records of user
-- ----------------------------
