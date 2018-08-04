/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-02 15:58:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sId` varchar(30) NOT NULL,
  `sName` varchar(30) DEFAULT NULL,
  `sAge` int(11) DEFAULT NULL,
  `sSex` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`sId`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('20081101', 'anni', '20', 'WM');
INSERT INTO `student` VALUES ('20081102', 'Jack', '20', 'M');
INSERT INTO `student` VALUES ('20081103', 'Tony', '21', 'M');
INSERT INTO `student` VALUES ('20081104', 'King', '22', 'WM');
INSERT INTO `student` VALUES ('20081105', 'Kevin', '23', 'M');
INSERT INTO `student` VALUES ('20081106', 'Rose', '19', 'WM');
