/*
Navicat MySQL Data Transfer

Source Server         : mySQL
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : blog_gp1701

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-06-09 13:04:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `bio` varchar(255) DEFAULT NULL,
  `favouriteSection` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('1', 'crachin', 'q1w2e3', null, null, null, null, null);
INSERT INTO `author` VALUES ('2', 'sfg', 'q1w2e3', null, null, null, null, null);
INSERT INTO `author` VALUES ('3', 'dg', 'q1w2e3', null, null, null, null, null);
INSERT INTO `author` VALUES ('4', 'dd', 'q1w2e3', null, null, null, null, null);

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `author_Id` int(11) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `featured` tinyint(4) DEFAULT NULL,
  `style` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `author` (`author_Id`),
  CONSTRAINT `author` FOREIGN KEY (`author_Id`) REFERENCES `author` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '测试', '1', 'ACTIVE', '0', '算了');
INSERT INTO `blog` VALUES ('2', '啊', '2', 'ACTIVE', '1', '代理费');
INSERT INTO `blog` VALUES ('3', 'a啊', '3', 'NULL ACTIVE', '1', '类似');
