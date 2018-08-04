/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-02 15:59:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tId` varchar(20) NOT NULL,
  `tName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`tId`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('t01', 'zeng');
INSERT INTO `teacher` VALUES ('t02', 'wang');
INSERT INTO `teacher` VALUES ('t03', 'zhao');
INSERT INTO `teacher` VALUES ('t04', 'yang');
INSERT INTO `teacher` VALUES ('t05', 'chen');
