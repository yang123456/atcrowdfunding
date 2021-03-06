-- 1.spring boot Demo mybatis 20171128 completed
-- https://github.com/luomouren/sbDemo/blob/master/src/main/resources/sql/database.text
DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `USER_ID` varchar(36) NOT NULL,
  `USER_NAME` varchar(30) NOT NULL,
  `REAL_NAME` varchar(30) DEFAULT NULL,
  `USER_PASSWORD` varchar(32) NOT NULL,
  `EMAIL` varchar(320) DEFAULT NULL,
  `CELLPHONE` varchar(15) DEFAULT NULL,
  `IS_FIRST_LOGIN` tinyint(1) NOT NULL DEFAULT '1',
  `IS_DELETED` tinyint(1) NOT NULL DEFAULT '0',
  `CREATED_TIME` datetime NOT NULL,
  `DESCRIPTION` varchar(200) DEFAULT NULL,
  `IS_SHOW_START_PAGE` tinyint(1) NOT NULL DEFAULT '1',
  `IS_ENABLE` tinyint(1) NOT NULL DEFAULT '1',
  `IS_PASSED` tinyint(4) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `Index_2` (`USER_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `sys_user`(`USER_ID`,`USER_NAME`,`REAL_NAME`,`USER_PASSWORD`,`EMAIL`,`CELLPHONE`,`IS_FIRST_LOGIN`,`IS_DELETED`,`CREATED_TIME`,`DESCRIPTION`,`IS_SHOW_START_PAGE`,`IS_ENABLE`,`IS_PASSED`) values ('e5792c05-fa1c-4ffa-9adb-aa66f2cd8863','admin','管理员','25d55ad283aa400af464c76d713c07ad','','',0,0,'2013-04-04 00:00:00',NULL,1,1,1);
