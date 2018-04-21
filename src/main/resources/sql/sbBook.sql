/*
 Navicat Premium Data Transfer

 Source Server         : monk
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost
 Source Database       : sbBook

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : utf-8

 Date: 04/21/2018 17:45:49 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `t_id` int(32) NOT NULL AUTO_INCREMENT,
  `t_username` varchar(32) NOT NULL,
  `t_password` varchar(32) NOT NULL,
  `t_email` varchar(32) DEFAULT NULL,
  `t_mobile` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
