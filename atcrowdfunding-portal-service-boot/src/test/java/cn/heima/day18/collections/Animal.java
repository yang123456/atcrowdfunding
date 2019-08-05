package cn.heima.day18.collections;
class Animal {
	public static void main(String[] args) {
		Cat c = new Cat("加菲",8);
		c.eat();
		c.sleep();

		JumpCat jc = new JumpCat("猫跳高",3);
		jc.eat();
		jc.sleep();
		jc.jump();
	}
}
abstract class Animal_1{
	private String name ;
	private int age ;

	public Animal_1(){}

	public Animal_1(String name, int age){
		this.name = name ;
		this.age = age;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return age;
	}
	public abstract void eat();

	public abstract void sleep();
}

interface Jumping{
	public void jump();
}
class Cat extends Animal_1{

	public	Cat(){}

	public Cat (String name , int age){
		super (name, age );
	}
	public void eat (){
		System.out.println("猫吃鱼");
	}
	public void sleep(){
		System.out.println("侧着睡");
	}
}
class JumpCat extends Cat implements Jumping{
	public JumpCat(){}

	public JumpCat (String name , int age){
		super (name, age);
	}
	public void jump(){
		System.out.println("猫跳高");
	}
}



		
