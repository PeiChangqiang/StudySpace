/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-02 15:58:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cId` varchar(10) NOT NULL,
  `cName` varchar(20) DEFAULT NULL,
  `tId` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cId`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('001', 'chinese', 't01');
INSERT INTO `course` VALUES ('002', 'english', 't02');
INSERT INTO `course` VALUES ('003', 'japanese', 't03');
INSERT INTO `course` VALUES ('004', 'physical', 't04');
INSERT INTO `course` VALUES ('005', 'history', 't05');
