数据库准备
-----------------------------------------------------
1.学生表           Student(S,Sname,Sage,Ssex)
Sid 学生编号
Sname 学生姓名
Sage 出生年月
Ssex 学生性别
-----------------------------------------------------
2.课程表           Course(C,Cname,T)
C 课程编号
Cname 课程名称
T 教师编号
-----------------------------------------------------
3.教师表           Teacher(T,Tname)
T 教师编号
Tname 教师姓名
-----------------------------------------------------
4.成绩表           SC(S,C,score)
S 学生编号
C 课程编号
score 分数
-----------------------------------------------------
create table Student(S varchar(10),Sname nvarchar(10),Sage datetime,Ssex nvarchar(10))
insert into Student values('01' , '赵雷' , '1990-01-01' , '男');
insert into Student values('02' , '钱电' , '1990-12-21' , '男');
insert into Student values('03' , '孙风' , '1990-05-20' , '男');
insert into Student values('04' , '李云' , '1990-08-06' , '男');
insert into Student values('05' , '周梅' , '1991-12-01' , '女');
insert into Student values('06' , '吴兰' , '1992-03-01' , '女');
insert into Student values('07' , '郑竹' , '1989-07-01' , '女');
insert into Student values('08' , '王菊' , '1990-01-20' , '女');
                                                               ;
create table Course(C varchar(10),Cname nvarchar(10),T varchar(10))
insert into Course values('01' , '语文' , '02');
insert into Course values('02' , '数学' , '01');
insert into Course values('03' , '英语' , '03');

create table Teacher(T varchar(10),Tname nvarchar(10))
insert into Teacher values('01' , '张三');
insert into Teacher values('02' , '李四');
insert into Teacher values('03' , '王五');

create table SC(S varchar(10),C varchar(10),score decimal(18,1))
insert into SC values('01' , '01' , 80);
insert into SC values('01' , '02' , 90);
insert into SC values('01' , '03' , 99);
insert into SC values('02' , '01' , 70);
insert into SC values('02' , '02' , 60);
insert into SC values('02' , '03' , 80);
insert into SC values('03' , '01' , 80);
insert into SC values('03' , '02' , 80);
insert into SC values('03' , '03' , 80);
insert into SC values('04' , '01' , 50);
insert into SC values('04' , '02' , 30);
insert into SC values('04' , '03' , 20);
insert into SC values('05' , '01' , 76);
insert into SC values('05' , '02' , 87);
insert into SC values('06' , '01' , 31);
insert into SC values('06' , '03' , 34);
insert into SC values('07' , '02' , 89);
insert into SC values('07' , '03' , 98);
----------------------数据--------------------------

1、查询"01"课程比"02"课程成绩高的学生的信息及课程分数
#查询"01"课程比"02"课程成绩高的学生的信息及课程分数
select stu.*, sc1.c, sc1.score, sc2.c, sc2.score
from
(select * from sc where c='01')sc1
,(select * from sc where c='02')sc2
,student stu
where stu.s=sc1.s
and stu.s=sc2.s
and sc1.score>sc2.score

3、查询平均成绩大于等于60分的同学的学生编号和学生姓名和平均成绩
#查询平均成绩大于等于60分的同学的学生编号和学生姓名和平均成绩
select stu.s, stu.sname, avg(sc.score) avgscore
from student stu,sc
where stu.s=sc.s
group by stu.S
having avgscore>60
5、查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩

#查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩
select stu.s, stu.sname, count(c), sum(score)
from student stu, sc
where stu.s=sc.s
group by sc.S
6、查询"李"姓老师的数量 

#6、查询"李"姓老师的数量 
select count(*)
from teacher tch
where tch.Tname like '李%'
7、查询学过"张三"老师授课的同学的信息

#7、查询学过"张三"老师授课的同学的信息
select stu.*
from student stu, sc
where stu.s=sc.s and sc.c in
(select co.c
from teacher te,course co
where te.t=co.t and te.Tname='张三')
8、查询没学过"张三"老师授课的同学的信息

#8、查询没学过"张三"老师授课的同学的信息
select *
from student stu1
where stu1.s not in (
	#7、查询学过"张三"老师授课的同学的信息(学号)
	select stu.s
	from student stu, sc
	where stu.s=sc.s and sc.c in
	(select co.c
	from teacher te,course co
	where te.t=co.t and te.Tname='张三')
)
9、查询学过编号为"01"并且也学过编号为"02"的课程的同学的信息

#9、查询学过编号为"01"并且也学过编号为"02"的课程的同学的信息

select stu.*
from student stu,sc
where stu.s=sc.s and sc.c='02' and stu.s in(

#查询学过编号为"01"的同学
select stu.s
from student stu, sc
where stu.s=sc.s and sc.c='01'
)
#自连接方法，sc与自身sc进行连接
#9、查询学过编号为"01"并且也学过编号为"02"的课程的同学的信息
select stu.*
from student stu, sc sc1, sc sc2
where sc1.c='01' and sc2.c='02' and sc1.s=sc2.s and stu.s=sc1.s
10、查询学过编号为"01"但是没有学过编号为"02"的课程的同学的信息

#10、查询学过编号为"01"但是没有学过编号为"02"的课程的同学的信息
select stu.*
from student stu,sc
where stu.s=sc.s and sc.c='01' and stu.s not in(

#查询学过编号为"02"的同学
select stu.s
from student stu, sc
where stu.s=sc.s and sc.c='02'
)
11、查询没有学全所有课程的同学的信息 

#11、查询没有学全所有课程的同学的信息 
select stu.*
from student stu, sc
where stu.s=sc.s
group by sc.s
having count(sc.c)<(
	select count(c) from course
)
12、查询至少有一门课与学号为"01"的同学所学相同的同学的信息 

#12、查询至少有一门课与学号为"01"的同学所学相同的同学的信息 

select distinct stu.*
from student stu, sc
where stu.s=sc.s and sc.c in(

	#学号为"01"所学的课
	select c
	from sc 
	where sc.s='01'

)
13、查询和"01"号的同学学习的课程完全相同的其他同学的信息

字符串拼接
关于查询和"1"号的同学学习的课程完全相同的其他同学的信息详细

SQL 拼接多个字段的值&一个字段多条记录的拼接

#15、查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩

#15、查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩

select stu.s, stu.sname, avg(score)
from student stu, sc
where stu.s=sc.s and stu.s in(

#两门及其以上不及格课程的同学的学号
select s
from sc
where score<60
group by s
having count(score)>=2

)
group by sc.s
16、检索"01"课程分数小于60，按分数降序排列的学生信息

#16、检索"01"课程分数小于60，按分数降序排列的学生信息
select stu.*
from student stu, sc
where stu.s=sc.s and sc.c='01' and sc.score<60
order by sc.score desc
17、按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩

#17、按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩

select stu.s, stu.sname,  avgs.avgscore, sc1.score, sc2.score, sc3.score
from student stu
left join sc sc1 on sc1.s=stu.s and sc1.c='01'
left join sc sc2 on sc2.s=stu.s and sc2.c='02'
left join sc sc3 on sc3.s=stu.s and sc3.c='03'
left join(
	#平均成绩
	select avg(score) avgscore, s
	from sc
	group by s
)avgs
on stu.s=avgs.s

18、查询各科成绩最高分、最低分和平均分：
#以如下形式显示：课程ID，课程name，最高分，最低分，平均分，及格率，中等率，优良率，优秀率
#及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90

#18、查询各科成绩最高分、最低分和平均分：
#以如下形式显示：课程ID，课程name，最高分，最低分，平均分，及格率，中等率，优良率，优秀率
#及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90
select sc.c 课程ID, cs.Cname 课程name, max(sc.score) 最高分, min(sc.score) 最低分, avg(sc.score) 平均分
,sum(case when sc.score>=60 then 1 else 0 end)/count(sc.score) 及格率

,sum(case when sc.score>=70 and sc.score < 80 then 1 else 0 end)/count(sc.score) 中等率
,sum(case when sc.score>=80 and sc.score < 90 then 1 else 0 end)/count(sc.score) 优良率
,sum(case when sc.score>=90 then 1 else 0 end)/count(sc.score) 优秀率
from sc, course cs 
where sc.c=cs.c
group by sc.c
#19、按各科成绩进行排序，并显示排名

MySQL中实现rank排名查询

#19、按各科成绩进行排序，并显示排名
select c,s,score
,if(@prec=c,@rank:=@rank+1,@rank:=1) 名次
,@prec:=c
from sc, (select @rank:=0)r, (select @prec:=-1)p
order by c,score desc
20、查询学生的总成绩并进行排名

#20、查询学生的总成绩并进行排名
select a.s,a.sumscore
,@rank:=@rank+1
from(
select s,sum(score) sumscore
from sc
group by s
order by sumscore desc)a, (select @rank:=0)r
#21、查询不同老师所教不同课程平均分从高到低显示 

#21、查询不同老师所教不同课程平均分从高到低显示 
select tea.tname,cr.Cname, avg(sc.score) avgscore
from teacher tea, sc,course cr
where tea.t=cr.t and cr.c=sc.c
group by sc.c
order by avgscore desc
22、查询所有课程的成绩第2名到第3名的学生信息及该课程成绩

#22、查询所有课程的成绩第2名到第3名的学生信息及该课程成绩
select a.*,b.Cname,c.score
from student a, course b
, (
select c,s,score
,if(@prec=c,@rank:=@rank+1,@rank:=1) rank
,@prec:=c
from sc, (select @rank:=0)r, (select @prec:=-1)p
order by c,score desc)c
where a.s=c.s and b.c=c.c and c.rank between 2 and 3
23、统计各科成绩各分数段人数：课程编号,课程名称,[100-85],[85-70],[70-60],[0-60]及所占百分比 

#23、统计各科成绩各分数段人数：课程编号,课程名称,[100-85],[85-70],[70-60],[0-60]及所占百分比 
select course.c,course.cname
,sum(case when sc.score<100 and sc.score>=85 then 1 else 0 end)/count(sc.score) 成绩100至85
,sum(case when sc.score<85 and sc.score>=70 then 1 else 0 end)/count(sc.score) 成绩85至70
,sum(case when sc.score<70 and sc.score>=60 then 1 else 0 end)/count(sc.score) 成绩70至60
,sum(case when sc.score<60  then 1 else 0 end)/count(sc.score)  成绩0至60
,count(sc.score)
from course,sc
where course.c=sc.c
group by sc.c
23、统计各科成绩各分数段人数：课程编号,课程名称,[100-85],[85-70],[70-60],[0-60]及所占百分比 

@rank,跟order by avg(score)要分开

#23、统计各科成绩各分数段人数：课程编号,课程名称,[100-85],[85-70],[70-60],[0-60]及所占百分比 
select course.c,course.cname
,sum(case when sc.score<100 and sc.score>=85 then 1 else 0 end)/count(sc.score) 成绩100至85
,sum(case when sc.score<85 and sc.score>=70 then 1 else 0 end)/count(sc.score) 成绩85至70
,sum(case when sc.score<70 and sc.score>=60 then 1 else 0 end)/count(sc.score) 成绩70至60
,sum(case when sc.score<60  then 1 else 0 end)/count(sc.score)  成绩0至60
,count(sc.score)
from course,sc
where course.c=sc.c
group by sc.c
25、查询各科成绩前三名的记录

select a.* from tb a where 2 > (select count(*) from tb where name = a.name and val > a.val ) order by a.name,a.val 
select a.* from tb a where val in (select top 2 val from tb where name=a.name order by val desc) order by a.name,a.val 
select a.* from tb a where exists (select count(*) from tb where name = a.name and val > a.val having Count(*) < 2) order by a.name 
/* 
name val memo 
---------- ----------- -------------------- 
a 2 a2(a的第二个值) 
a 3 a3:a的第三个值 
b 4 b4b4 
b 5 b5b5b5b5b5 
*/
#mysql不支持用top，用limit N,但in()里不支持使用limit，所以第二种方法mysql不能使用
#25、查询各科成绩前三名的记录
#select a.* from tb a where 2 > (select count(*) from tb where name = a.name and val > a.val ) #order by a.name,a.val 
select a.*
from sc a
where 3>(select count(*) from sc where c=a.c and score>a.score )
order by a.c,a.score desc
#25、查询各科成绩前三名的记录
#select a.* from tb a 
#where exists (select count(*) from tb where name = a.name and val > a.val having Count(*) < 2) 
#order by a.name 
select a.* from sc a
where exists (select count(*) from sc where c=a.c and score > a.score having count(*)<3)
order by a.c
27、查询出只有两门课程的全部学生的学号和姓名

#27、查询出只有两门课程的全部学生的学号和姓名
select st.s,st.sname
from student st,sc
where st.s=sc.s
group by sc.s
having count(*)=2
28、查询男生、女生人数

#28、查询男生、女生人数
select ssex,count(*)
from student
group by ssex
29、查询名字中含有"风"字的学生信息

#29、查询名字中含有"风"字的学生信息
SELECT * FROM student 
WHERE Sname rLIKE '风'
#30、查询同名同性学生名单，并统计同名人数 

#30、查询同名同性学生名单，并统计同名人数 
#30、查询同科同分学生名单，并统计同分人数 
select c,score,count(*)
from sc
group by c,score
having count(*)>=2
31、查询1990年出生的学生名单(注：Student表中Sage列的类型是datetime) 

#31、查询1990年出生的学生名单(注：Student表中Sage列的类型是datetime) 
select * from student
where sage like '1990%'
#31、查询1990年出生的学生名单(注：Student表中Sage列的类型是datetime) 
select * from student
where extract(year from sage)='1990' 
32、查询每门课程的平均成绩，结果按平均成绩降序排列，平均成绩相同时，按课程编号

#32、查询每门课程的平均成绩，结果按平均成绩降序排列，平均成绩相同时，按课程编号
select cr.cname,avg(sc.score) avgscore
from course cr, sc
where cr.c=sc.c
group by sc.c
order by avgscore desc,sc.c
33、查询平均成绩大于等于85的所有学生的学号、姓名和平均成绩

#33、查询平均成绩大于等于85的所有学生的学号、姓名和平均成绩 
select st.s,st.Sname,avg(sc.score) avgscore
from student st,sc
where st.s=sc.s
group by sc.s
having avgscore>=85
34、查询课程名称为"数学"，且分数低于60的学生姓名和分数 

#34、查询课程名称为"数学"，且分数低于60的学生姓名和分数 
select st.sname,sc.score
from student st,course cr,sc
where st.s=sc.s and sc.c=cr.c and cr.cname='数学' and score<60
35、查询所有学生的课程及分数情况

#35、查询所有学生的课程及分数情况
select student.sname,course.cname,sc.score
from student,course,sc
where student.s=sc.s and sc.c=course.c
36、查询任何一门课程成绩在70分以上的姓名、课程名称和分数

#36、查询任何一门课程成绩在70分以上的姓名、课程名称和分数
select student.sname,course.cname,sc.score
from student, course, sc
where student.s=sc.s and course.c=sc.c and sc.score>=70
37、查询不及格的课程

#37、查询不及格的课程
select student.sname,course.cname,sc.score
from student, course, sc
where student.s=sc.s and course.c=sc.c and sc.score<60
38、查询课程编号为01且课程成绩在80分以上的学生的学号和姓名

#38、查询课程编号为01且课程成绩在80分以上的学生的学号和姓名
select student.s,student.sname
from student,sc
where student.s=sc.s and sc.c='01' and sc.score>=80
39、求每门课程的学生人数 

#39、求每门课程的学生人数 
select course.cname, count(1)
from course ,sc
where course.c=sc.c
group by sc.c
40、查询选修"张三"老师所授课程的学生中，成绩最高的学生信息及其成绩

#40、查询选修"张三"老师所授课程的学生中，成绩最高的学生信息及其成绩
select student.*,max(score)
from student,teacher,course,sc
where teacher.tname='张三' and teacher.t=course.t and course.c=sc.c and sc.s=sc.s
group by sc.c
41、查询不同课程成绩相同的学生的学生编号、课程编号、学生成绩 

#41、查询不同课程成绩相同的学生的学生编号、课程编号、学生成绩 
select *
from sc where s in
(select s
from sc
group by s,score
having count(*)>1)
42、查询每门功成绩最好的前两名  

#查询每门课程成绩最好的前两名
select a.* from sc a
where 2>
(select count(*)from sc
where c=a.c and score>a.score)
order by a.c,a.score
43、统计每门课程的学生选修人数（超过5人的课程才统计）。要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列

#统计每门课程的学生选修人数（超过5人的课程才统计）。
#要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列  
select a.c, a.Cname, count(b.c) countc
from course a, sc b
where a.c=b.c
group by b.c
having countc>5
order by countc desc, a.c
44、检索至少选修两门课程的学生学号

#44、检索至少选修两门课程的学生学号 
select a.s, a.Sname,count(*) countc
from student a, sc b
where a.s=b.s
group by a.S
having countc>=2
45、查询选修了全部课程的学生信息

#45、查询选修了全部课程的学生信息 
select a.*
from student a, sc b
where a.s = b.s
group by b.s
having count(b.c)=
(select count(distinct c)
from sc)
46、查询各学生的年龄

47、查询本周过生日的学生

#47、查询本周过生日的学生(不怎么对)
#计算日期 d 是本年的第几个星期WEEK(d)(应该不能用week)（根据定义和测试，好像有可以）
select * from student where week(sage)=week(now())
48、查询下周过生日的学生

49、查询本月过生日的学生

50、查询下月过生日的学生






























