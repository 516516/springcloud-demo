/*
Navicat MySQL Data Transfer

Source Server         : study_personal
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : study2

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2020-11-07 16:21:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `age` int(11) NOT NULL DEFAULT '0',
  `adreess` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=swe7;
