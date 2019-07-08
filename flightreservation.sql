/*
Navicat MySQL Data Transfer

Source Server         : graduate
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : flightreservation

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2019-07-08 22:11:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ticket`
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `ticketID` varchar(255) NOT NULL,
  `Ctiy01` varchar(255) NOT NULL,
  `Ctiy02` varchar(255) NOT NULL,
  `EntTime` varchar(255) NOT NULL,
  `ticketCount` int(11) NOT NULL,
  PRIMARY KEY (`ticketID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ticket
-- ----------------------------
INSERT INTO `ticket` VALUES ('test', 'test', 'test', 'test', '100');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10299019920830680X', '10299019920830680X', '112232112222', '598157378@qq.com');
INSERT INTO `user` VALUES ('109080199209319089', '109080199209319089', '13223454325', 'quan0xi@qq.com');
INSERT INTO `user` VALUES ('111111111111111', '111111111111111', '111111111111111', '111111111111111@q.c');
INSERT INTO `user` VALUES ('111111111111111111', '111111111111111111', '111111111111111111', 'f@s.c');
INSERT INTO `user` VALUES ('111111111111111222', '111111111111111222', '111111111111111222', '1111111111111@df.ca');
INSERT INTO `user` VALUES ('121234234321234', '121234234321234', '121234234321234', '1@2.2');
INSERT INTO `user` VALUES ('142327199204282033', '142327199204282033', '142327199204282033', 'sdfa@qq.com');
INSERT INTO `user` VALUES ('test', 'test', '11111111111', 'test@qq.com');
