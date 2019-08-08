/*
Navicat MySQL Data Transfer

Source Server         : dev
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : atcrowdfunding-v

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2019-08-08 20:07:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `province_id` int(10) DEFAULT NULL,
  `city_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '1', 'shanghai', '好城市');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('5');

-- ----------------------------
-- Table structure for jpa_t_user
-- ----------------------------
DROP TABLE IF EXISTS `jpa_t_user`;
CREATE TABLE `jpa_t_user` (
  `id` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jpa_t_user
-- ----------------------------
INSERT INTO `jpa_t_user` VALUES ('1', '123', 'fasfas');
INSERT INTO `jpa_t_user` VALUES ('2', '123456', 'liis');
INSERT INTO `jpa_t_user` VALUES ('3', '123456', 'liis');
INSERT INTO `jpa_t_user` VALUES ('4', '123456', 'liis');

-- ----------------------------
-- Table structure for t_manager
-- ----------------------------
DROP TABLE IF EXISTS `t_manager`;
CREATE TABLE `t_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `manguid` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `regip` varchar(255) DEFAULT NULL,
  `regtime` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_manager
-- ----------------------------
INSERT INTO `t_manager` VALUES ('1', 'aa', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_manager` VALUES ('2', '123', '黄冈', '中国', '7623214@qq.com', '0001', '张三', '123456', '湖北', '127.0.0.1', '2018-11-11 00:00:00', '0');

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `url` varchar(225) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  `open` tinyint(4) DEFAULT NULL,
  `checked` tinyint(4) DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', '文件管理', null, '0', '1', '1', null);
INSERT INTO `t_permission` VALUES ('2', '班级文件', null, '1', '1', '1', null);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'zz');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `roleid` int(20) DEFAULT NULL,
  `permissionid` int(29) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `loginacct` varchar(20) DEFAULT NULL,
  `userpswd` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `createtime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'admin', '123', '777777@qq.com', null);
INSERT INTO `t_user` VALUES ('2', '张三1', 'zhangsan', '123456', '76321112432@qq.com', '2019-08-08 19:32:48');
INSERT INTO `t_user` VALUES ('3', 'rwqerqwr', 'qr', '123456', '212424443@qq.com', '2019-08-08 19:52:02');
INSERT INTO `t_user` VALUES ('4', '赵钱孙李', '1124', '12', '76321112432@qq.com', null);
INSERT INTO `t_user` VALUES ('5', '周吴郑王', 'a', '24', '76321112432@qq.com', null);
INSERT INTO `t_user` VALUES ('6', '冯陈褚卫', 'sv', '4124', '76321112432@qq.com', null);
INSERT INTO `t_user` VALUES ('7', '蒋沈韩杨', 'vvert', '141', '76321112432@qq.com', null);
INSERT INTO `t_user` VALUES ('8', '朱秦尤许', 'vvv', '2412', '76321112432@qq.com', null);
INSERT INTO `t_user` VALUES ('9', '何吕施张', 're', '412', '76321112432@qq.com', null);
INSERT INTO `t_user` VALUES ('10', '华', 'vv', '1241', '76321112432@qq.com', null);
INSERT INTO `t_user` VALUES ('11', '金魏陶', 'v', '41241', '76321112432@qq.com', null);
INSERT INTO `t_user` VALUES ('12', '孔曹严', 'v', '2', '76321112432@qq.com', null);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `userid` int(20) DEFAULT NULL,
  `roleid` int(29) DEFAULT NULL,
  `id` int(29) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `age` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangsan', '12');
INSERT INTO `user` VALUES ('2', '啊啊啊', '12');
