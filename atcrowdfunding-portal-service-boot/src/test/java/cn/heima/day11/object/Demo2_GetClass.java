package cn.heima.day11.object;


import cn.heima.day11.bean.Student;

public class Demo2_GetClass {

	public static void main(String[] args) {
		Student s = new Student("张三", 23);
		// Class clazz = new Class();

		Class clazz = s.getClass();
		String name = clazz.getName();
		System.out.println(name);
	}
}
