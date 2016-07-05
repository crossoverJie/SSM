/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-07-05 18:50:54
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
  `description` text,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'jack', 'abc123', '你的');
INSERT INTO `user` VALUES ('2', 'zhangsan', 'abc123', '打算打算');
INSERT INTO `user` VALUES ('3', 'lisi', 'abc123', '费大幅度');
INSERT INTO `user` VALUES ('4', 'wangwu', 'abc123', '放到的');
INSERT INTO `user` VALUES ('5', 'xiaolong', 'abc123', '发的发');
INSERT INTO `user` VALUES ('6', '艾弗森', 'abc123', '阿伦·艾弗森1996年6月26日被费城76人队选中，成为NBA状元秀。艾弗森14年职业生涯先后效力过费城76人队、掘金、灰熊和活塞， 场均出战41.1分钟，获得26.7分、6.2次助攻和2.2次抢断。在整个职业生涯中，艾弗森四次荣膺得分王，11次入选全明星，三次荣膺抢断王。2000-2001赛季，艾弗森打出了生涯最好表现，夺得常规赛MVP奖杯，并帮助76队打入NBA总决赛。');
INSERT INTO `user` VALUES ('7', '库里', 'abc123', '斯蒂芬·库里2009年通过选秀进入NBA后一直效力于勇士队，新秀赛季入选最佳新秀第一阵容；2014-15赛季随勇士队获得NBA总冠军；两次当选常规赛MVP，两次入选最佳阵容第一阵容，三次入选全明星赛西部首发阵容。斯蒂芬·库里2010年随美国队获土耳其世锦赛冠军，2014年随美国队获西班牙篮球世界杯冠军。');
INSERT INTO `user` VALUES ('8', '维斯布鲁克', '1111', '拉塞尔·威斯布鲁克于2008年通过选秀进入NBA，新秀赛季入选最佳新秀阵容第一阵容；2010年随美国队获得土耳其篮球世锦赛冠军，2012年随美国男篮获得伦敦奥运会冠军；5次入选全明星阵容，2015、2016连续两年获得全明星赛MVP；2015-16赛季入选最佳阵容第一阵容，4次入选最佳阵容第二阵容。');
INSERT INTO `user` VALUES ('9', '凯里·欧文', '6666', '凯里·欧文2011年以选秀状元身份进入NBA，新秀赛季当选最佳新秀；2014年首次入选全明星正赛先发阵容，并当选最有价值球员；同年代表美国队参加男篮世界杯，获得冠军并当选MVP；2014-15赛季入选最佳阵容第三阵容；2015-16赛季随骑士队获得NBA总冠军。');
