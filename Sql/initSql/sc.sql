/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-02 15:58:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `sId` varchar(30) DEFAULT NULL,
  `cId` varchar(10) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  KEY `sId` (`sId`),
  KEY `cId` (`cId`),
  CONSTRAINT `sc_ibfk_1` FOREIGN KEY (`sId`) REFERENCES `student` (`sId`),
  CONSTRAINT `sc_ibfk_2` FOREIGN KEY (`cId`) REFERENCES `course` (`cId`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES ('20081101', '001', '100');
INSERT INTO `sc` VALUES ('20081102', '002', '90');
INSERT INTO `sc` VALUES ('20081102', '001', '91');
INSERT INTO `sc` VALUES ('20081103', '001', '89');
INSERT INTO `sc` VALUES ('20081103', '002', '97');
