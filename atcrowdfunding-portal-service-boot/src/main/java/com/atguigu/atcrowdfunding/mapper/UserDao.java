package com.atguigu.atcrowdfunding.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import com.atguigu.atcrowdfunding.domain.User;
import java.util.List;

//1 @Mapper将UserDao声明为一个Mapper接口
//2 @Results是结果映射列表，@Result中property是User类的属性名，colomn是数据库表的字段名
//3 @Select, @Insert 分别代表了执行的真实SQL

@Mapper // 1
public interface UserDao {
	@Results({ // 2
			@Result(property = "id", column = "id"), // 2
			@Result(property = "name", column = "name"), @Result(property = "age", column = "age") })
	@Select("SELECT * FROM user WHERE age = #{age}") // 3
	List<User> get(int age);

	@Insert("INSERT INTO user(name, age) VALUES (#{name}, #{age})") // 3
	void insert(User user);
}
