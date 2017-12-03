/*
 Navicat Premium Data Transfer

 Source Server         : local_mysql
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost
 Source Database       : test

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : utf-8

 Date: 12/03/2017 20:56:20 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_news`
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `address` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `description` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `news_time` datetime DEFAULT NULL,
  `title` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `t_news`
-- ----------------------------
BEGIN;
INSERT INTO `t_news` VALUES ('31c673070cfa480e9a89bb7d389767c5', 'AA', '2017-07-10 12:52:54', 'AA', '2017-07-10 12:56:43', 'AA'), ('6c0517e1ec0c4831ab93a6c967aacbec', 'CC', '2017-07-10 13:07:28', 'CC', '2017-07-10 13:09:13', 'CC'), ('8714509c7bfb4e2b9a944d3c82b0d001', 'DD', '2017-07-10 12:58:57', 'DD', '2017-07-10 13:09:16', 'DD'), ('f40d6da72fa448ada5d7b9d17e19c582', 'BB', '2017-07-10 12:52:13', 'BB', '2017-07-10 12:56:46', 'BB');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
