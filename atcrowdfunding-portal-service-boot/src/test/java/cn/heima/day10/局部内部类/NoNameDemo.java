package cn.heima.day10.局部内部类;

class NoNameDemo {
    public static void main(String[] args) {
        //需求:请用代码实现调用 method方法?
		/*方案一做法:
		Test t = new Test();
		//通过分析,这个method需要我们传入一个Inter接口的子实现类对象
		t.method(new InterImpl()); //把这个子实现类对象传进去
		*/

        //这是方案二: 通过方案二和方案一的对比,我们可以看出来,匿名内部类可以简化我们的代码书写,我们只需要在传参数的时候传入一个匿名内部类对象就可以实现方法的调用
        //节省代码
        Test t = new Test();
        t.method(new Inter(){
            public void add(){
                System.out.println("这是匿名内部类的add方法");
            }
        });

    }
}

interface Inter
{
    public abstract void add();
}

class Test
{
    public void method(Inter i){ //Inter i = new InterImpl();   子实现类对象;
        //编译看父类,运行看子类
        i.add();
    }
}


//方案一:写一个子实现类
class InterImpl implements Inter
{
    public void add(){
        System.out.println("添加方法");
    }
}