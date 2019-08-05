package cn.heima.day11.idea;

/**
 * <p>Title: Demo11</p>
 * <p>Description: </p>
 * <p>Company: www.wilson.com</p>
 *
 * @author Wilson
 * @version 1.0
 * @date 2019-06-23 15:24
 */
public class Demo11 {
    /*
     * A:新建
     * B:格式化  CTRL+ALT+L
     * C:导入包  CTRL+ENTER
     * D:注释  ctrl+/,ctrl+shift+/,ctrl+shift+\
     * E:代码上下移动 选中代码CTRL+SHIFT+上/下箭头
     * F:查看源码  选中类名(CTRL+Q或者Ctrl+鼠标点击)
     * G:查找具体的类 \shift双击 或 CTRL + N
     * H:查找具体类的具体方法 shift双击 或 CTRL + N
     * I:给建议 ctrl+SHIFT+space,根据右边生成左边的数据类型,生成方法
     * J:删除代码 ctrl + Y
     * K:抽取方法CTRL + ALT + m
     * L:改名 SHIFT+F6
     */

    public static void main(String[] args) {
        //demo2();
        //Student student = new Student("张三", 23);
        //System.out.println(student.getName() +"..."+ student.getAge());

    }

    private static void demo2() {
        int[] arr1 = { 11, 22, 33, 44, 55 };

        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        // Scanner scanner = new Scanner(System.in);

        int a = 10;
        int b = 20;
        int sum = add(a, b);
    }

    public static int add(int a, int b) {
        return a + b;
    }
}
