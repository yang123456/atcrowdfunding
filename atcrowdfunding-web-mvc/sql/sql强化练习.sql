/*
Navicat MySQL Data Transfer

Source Server         : dev
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : db1

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2019-08-13 14:58:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `C` varchar(10) DEFAULT NULL,
  `Cname` varchar(10) DEFAULT NULL,
  `T` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('01', '语文', '02');
INSERT INTO `course` VALUES ('02', '数学', '01');
INSERT INTO `course` VALUES ('03', '英语', '03');

-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `S` varchar(10) DEFAULT NULL,
  `C` varchar(10) DEFAULT NULL,
  `score` decimal(18,1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES ('01', '01', '80.0');
INSERT INTO `sc` VALUES ('01', '02', '90.0');
INSERT INTO `sc` VALUES ('01', '03', '99.0');
INSERT INTO `sc` VALUES ('02', '01', '70.0');
INSERT INTO `sc` VALUES ('02', '02', '60.0');
INSERT INTO `sc` VALUES ('02', '03', '80.0');
INSERT INTO `sc` VALUES ('03', '01', '80.0');
INSERT INTO `sc` VALUES ('03', '02', '80.0');
INSERT INTO `sc` VALUES ('03', '03', '80.0');
INSERT INTO `sc` VALUES ('04', '01', '50.0');
INSERT INTO `sc` VALUES ('04', '02', '30.0');
INSERT INTO `sc` VALUES ('04', '03', '20.0');
INSERT INTO `sc` VALUES ('05', '01', '76.0');
INSERT INTO `sc` VALUES ('05', '02', '87.0');
INSERT INTO `sc` VALUES ('06', '01', '31.0');
INSERT INTO `sc` VALUES ('06', '03', '34.0');
INSERT INTO `sc` VALUES ('07', '02', '89.0');
INSERT INTO `sc` VALUES ('07', '03', '98.0');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `S` varchar(10) DEFAULT NULL,
  `Sname` varchar(10) DEFAULT NULL,
  `Sage` datetime DEFAULT NULL,
  `Ssex` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('01', '赵雷', '1990-01-01 00:00:00', '男');
INSERT INTO `student` VALUES ('02', '钱电', '1990-12-21 00:00:00', '男');
INSERT INTO `student` VALUES ('03', '孙风', '1990-05-20 00:00:00', '男');
INSERT INTO `student` VALUES ('04', '李云', '1990-08-06 00:00:00', '男');
INSERT INTO `student` VALUES ('05', '周梅', '1991-12-01 00:00:00', '女');
INSERT INTO `student` VALUES ('06', '吴兰', '1992-03-01 00:00:00', '女');
INSERT INTO `student` VALUES ('07', '郑竹', '1989-07-01 00:00:00', '女');
INSERT INTO `student` VALUES ('08', '王菊', '1990-01-20 00:00:00', '女');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `T` varchar(10) DEFAULT NULL,
  `Tname` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('01', '张三');
INSERT INTO `teacher` VALUES ('02', '李四');
INSERT INTO `teacher` VALUES ('03', '王五');
