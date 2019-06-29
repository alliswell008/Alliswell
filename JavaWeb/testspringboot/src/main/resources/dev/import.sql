/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2017-10-03 20:18:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user_account
-- ----------------------------
DROP TABLE IF EXISTS `t_user_account`;
CREATE TABLE `t_user_account` (
  `id` bigint(20) DEFAULT NULL COMMENT '主键id',
  `account` varchar(20) DEFAULT NULL COMMENT '用户账号，手机号码',
  `passwd` varchar(64) DEFAULT NULL COMMENT '账号密码，采用md5加密',
  `personId` bigint(20) DEFAULT NULL COMMENT '人员id',
  `ctime` datetime DEFAULT NULL COMMENT '账号创建时间',
  `mtime` datetime DEFAULT NULL COMMENT '账号更新时间'
);

-- ----------------------------
-- Records of t_user_account
-- ----------------------------
INSERT INTO `t_user_account` VALUES ('1', 'test', '1234', '1', '2017-10-03 17:28:35', null);
INSERT INTO `t_user_account` VALUES ('2', 'test2', '1234', '2', '2017-10-03 17:55:48', null);
INSERT INTO `t_user_account` VALUES ('3', 'test3', '1234', '3', '2017-10-03 17:56:03', null);
