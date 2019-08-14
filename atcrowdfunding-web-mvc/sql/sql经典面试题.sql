1.用一条SQL 语句 查询出每门课都大于80 分的学生姓名

name   kecheng   fenshu
张三    语文       81
张三     数学       75
李四     语文       76
李四     数学       90
王五     语文       81
王五     数学       100
王五     英语       90

DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu` (
  `name` varchar(10) DEFAULT NULL,
  `kecheng` varchar(10) DEFAULT NULL,
  `fenshu` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `stu` VALUES ('张三', '语文', '81');
INSERT INTO `stu` VALUES ('张三', '数学', '75');
INSERT INTO `stu` VALUES ('李四', '语文', '76');
INSERT INTO `stu` VALUES ('李四', '数学', '90');
INSERT INTO `stu` VALUES ('王五', '语文', '81');
INSERT INTO `stu` VALUES ('王五', '数学', '100');
INSERT INTO `stu` VALUES ('王五', '英语', '90');

----------------------------------------------------------