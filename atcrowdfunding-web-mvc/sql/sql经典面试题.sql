1.用一条SQL 语句 查询出每门课都大于80 分的学生姓名

name   kecheng   fenshu
张三    语文       81
张三     数学       75
李四     语文       76
李四     数学       90
王五     语文       81
王五     数学       100
王五     英语       90

DROP TABLE IF EXISTS `stu1`;
CREATE TABLE `stu1` (
  `name` varchar(10) DEFAULT NULL,
  `kecheng` varchar(10) DEFAULT NULL,
  `fenshu` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `stu1` VALUES ('张三', '语文', '81');
INSERT INTO `stu1` VALUES ('张三', '数学', '75');
INSERT INTO `stu1` VALUES ('李四', '语文', '76');
INSERT INTO `stu1` VALUES ('李四', '数学', '90');
INSERT INTO `stu1` VALUES ('王五', '语文', '81');
INSERT INTO `stu1` VALUES ('王五', '数学', '100');
INSERT INTO `stu1` VALUES ('王五', '英语', '90');

A: select distinct name from stu1 where name not in (select distinct name from stu1 where fenshu<=80)
select name from stu1 group by name having min(fenshu)>80
----------------------------------------------------------

2. 学生表 如下:
自动编号   学号     姓名   课程编号     课程名称       分数
id       stuno   name  courseno   coursename   score
1        2005001 张三   0001      数学           69
2        2005002 李四   0001      数学           89
3        2005001 张三   0001      数学           69
CREATE TABLE `stu2` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `stuno` varchar(10) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `courseno` varchar(10) DEFAULT NULL,
  `coursename` varchar(10) DEFAULT NULL,
  `score` varchar(10) DEFAULT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `db1`.`stu2` (`id`, `stuno`, `name`, `courseno`, `coursename`, `score`) VALUES ('1', '2005001', '张三', '0001', '数学', '69');
INSERT INTO `db1`.`stu2` (`id`, `stuno`, `name`, `courseno`, `coursename`, `score`) VALUES ('2', '2005002', '李四', '0001', '数学', '89');
INSERT INTO `db1`.`stu2` (`id`, `stuno`, `name`, `courseno`, `coursename`, `score`) VALUES ('3', '2005001', '张三', '0001', '数学', '89');

删除除了自动编号不同, 其他都相同的学生冗余信息
A: delete tablename where 自动编号 not in(select min( 自动编号) from tablename group by学号, 姓名, 课程编号, 课程名称, 分数)
----------------------------------------------------------

3.一个叫 team 的表，里面只有一个字段name, 一共有4 条纪录，分别是a,b,c,d, 对应四个球对，现在四个球对进行比赛，用一条sql 语句显示所有可能的比赛组合.
你先按你自己的想法做一下，看结果有我的这个简单吗？
CREATE TABLE `team` (
  `name` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `db1`.`team` (`name`) VALUES ('a');
INSERT INTO `db1`.`team` (`name`) VALUES ('b');
INSERT INTO `db1`.`team` (`name`) VALUES ('c');
INSERT INTO `db1`.`team` (`name`) VALUES ('d');
答：select a.name, b.name
from team a, team b 
where a.name < b.name
----------------------------------------------------------

5.面试题：怎么把这样一个表儿
year   month amount
1991   1     1.1
1991   2     1.2
1991   3     1.3
1991   4     1.4
1992   1     2.1
1992   2     2.2
1992   3     2.3
1992   4     2.4
查成这样一个结果
year m1   m2   m3   m4
1991 1.1 1.2 1.3 1.4
1992 2.1 2.2 2.3 2.4 

CREATE TABLE `calender` (
  `year` varchar(10) DEFAULT NULL,
  `month` varchar(10) DEFAULT NULL,
  `amount` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `db1`.`calender` (`year`, `month`, `amount`) VALUES ('1991', '1', '1.1');
INSERT INTO `db1`.`calender` (`year`, `month`, `amount`) VALUES ('1991', '2', '1.2');
INSERT INTO `db1`.`calender` (`year`, `month`, `amount`) VALUES ('1991', '3', '1.3');
INSERT INTO `db1`.`calender` (`year`, `month`, `amount`) VALUES ('1991', '4', '1.4');
INSERT INTO `db1`.`calender` (`year`, `month`, `amount`) VALUES ('1992', '1', '2.1');
INSERT INTO `db1`.`calender` (`year`, `month`, `amount`) VALUES ('1992', '2', '2.2');
INSERT INTO `db1`.`calender` (`year`, `month`, `amount`) VALUES ('1992', '3', '2.3');
INSERT INTO `db1`.`calender` (`year`, `month`, `amount`) VALUES ('1992', '4', '2.4');
答案一、
select year, 
(select amount from   aaa m where month=1   and m.year=aaa.year) as m1,
(select amount from   aaa m where month=2   and m.year=aaa.year) as m2,
(select amount from   aaa m where month=3   and m.year=aaa.year) as m3,
(select amount from   aaa m where month=4   and m.year=aaa.year) as m4
from aaa   group by year
----------------------------------------------------------

6. 说明：复制表( 只复制结构, 源表名：a新表名：b) 
SQL: select * into b from a where 1<>1       (where1=1，拷贝表结构和数据内容)
Oracle:create table b As Select * from a where 1=2
[<>（不等于）(SQL Server Compact)

比较两个表达式。 当使用此运算符比较非空表达式时，如果左操作数不等于右操作数，则结果为 TRUE。 否则，结果为 FALSE。]
----------------------------------------------------------
7. 说明：拷贝表( 拷贝数据, 源表名：a目标表名：b) 

SQL: insert into b(a, b, c) select d,e,f from a; 
----------------------------------------------------------
11. 说明：两张关联表，删除主表中已经在副表中没有的信息

SQL: 
Delete from info where not exists (select * from infobz where info.infid=infobz.infid )
----------------------------------------------------------
12.有两个表A 和B ，均有key 和value 两个字段，如果B 的key 在A 中也有，就把B 的value 换为A 中对应的value
这道题的SQL 语句怎么写？

update b set b.value=(select a.value from a where a.key=b.key) where b.id in(select b.id from b,a where b.key=a.key);
----------------------------------------------------------

13.高级sql 面试题

原表:
courseid coursename score
-------------------------------------
1          Java    70
2          oracle    90
3         xml        40
4         jsp        30
5         servlet    80
-------------------------------------
为了便于阅读, 查询此表后的结果显式如下( 及格分数为60):
courseid coursename score mark
---------------------------------------------------
1     Java    70           pass
2      oracle 90          pass
3      xml    40          fail
4     jsp     30          fail
5     servlet 80          pass

写出此查询语句
CREATE TABLE `course2` (
  `courseid` int(10) NOT NULL AUTO_INCREMENT,
  `coursename` varchar(10) DEFAULT NULL,
  `score` varchar(10) DEFAULT NULL
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `db1`.`course2` (`courseid`, `coursename`, `score`) VALUES ('1', 'Java', '70');
INSERT INTO `db1`.`course2` (`courseid`, `coursename`, `score`) VALUES ('2', 'oracle', '90');
INSERT INTO `db1`.`course2` (`courseid`, `coursename`, `score`) VALUES ('3', 'xml', '40');
INSERT INTO `db1`.`course2` (`courseid`, `coursename`, `score`) VALUES ('4', 'jsp', '30');
INSERT INTO `db1`.`course2` (`courseid`, `coursename`, `score`) VALUES ('5', 'servlet', '80');
select courseid, coursename ,score ,decode（sign(score-60),-1,'fail','pass') as mark from course

---------------------------------------------------

SQL面试题（1）

create table testtable1
(
id int IDENTITY,
department varchar(12) 
)

select * from testtable1
insert into testtable1 values('设计')
insert into testtable1 values('市场')
insert into testtable1 values('售后')
/*
结果
id department
1   设计
2   市场
3   售后 
*/
create table testtable2
(
id int IDENTITY,
dptID int,
name varchar(12)
)
insert into testtable2 values(1,'张三')
insert into testtable2 values(1,'李四')
insert into testtable2 values(2,'王五')
insert into testtable2 values(3,'彭六')
insert into testtable2 values(4,'陈七')
/*
用一条SQL语句，怎么显示如下结果
id dptID department name
1   1      设计        张三
2   1      设计        李四
3   2      市场        王五
4   3      售后        彭六
5   4      黑人        陈七
*/

答案：

SELECT testtable2.* , ISNULL(department,'黑人')
FROM testtable1 right join testtable2 on testtable2.dptID = testtable1.ID
---------------------------------------------------

sql面试题（2）

有表A，结构如下： 
A: 
p_ID p_Num s_id 
1    10    01 
1    12    02 
2    8     01 
3   11     01 
3    8     03 
其中：p_ID为产品ID，p_Num为产品库存量，s_id为仓库ID。请用SQL语句实现将上表中的数据合并，合并后的数据为： 
p_ID s1_id s2_id s3_id 
1 10 12 0 
2 8 0 0 
3 11 0 8 
其中：s1_id为仓库1的库存量，s2_id为仓库2的库存量，s3_id为仓库3的库存量。如果该产品在某仓库中无库存量，那么就是0代替。
CREATE TABLE `myPro` (
  `p_ID` int(10) NOT NULL,
  `p_Num` varchar(10) DEFAULT NULL,
  `s_id` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `db1`.`mypro` (`p_ID`, `p_Num`, `s_id`) VALUES ('1', '10', '01');
INSERT INTO `db1`.`mypro` (`p_ID`, `p_Num`, `s_id`) VALUES ('1', '12', '02');
INSERT INTO `db1`.`mypro` (`p_ID`, `p_Num`, `s_id`) VALUES ('2', '8', '01');
INSERT INTO `db1`.`mypro` (`p_ID`, `p_Num`, `s_id`) VALUES ('3', '11', '01');
INSERT INTO `db1`.`mypro` (`p_ID`, `p_Num`, `s_id`) VALUES ('3', '8', '03');
结果：

select p_id ,
sum(case when s_id=1 then p_num else 0 end) as s1_id
,sum(case when s_id=2 then p_num else 0 end) as s2_id
,sum(case when s_id=3 then p_num else 0 end) as s3_id
from myPro group by p_id

---------------------------------------------------

SQL面试题（4）

1.查询A(ID,Name)表中第31至40条记录，ID作为主键可能是不是连续增长的列，完整的查询语句如下：

select top 10 * from A where ID >(select max(ID) from (select top 30 ID from A order by A ) T) order by A

2.查询表A中存在ID重复三次以上的记录,完整的查询语句如下：
select * from(select count(ID) as count from table group by ID)T where T.count>3
