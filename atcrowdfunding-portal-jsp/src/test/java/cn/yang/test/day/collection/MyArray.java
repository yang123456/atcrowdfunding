package cn.yang.test.day.collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//假设顺序列表ArrayList中存储的元素是整型数字1~5，遍历每个元素，将每个元素顺序输出。 [必做题]
public class MyArray {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> it = list.iterator();
//      迭代器遍历
        while(it.hasNext()){
            System.out.println(it.next());
        }
//      for循环遍历
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
//      增强for循环
        for(Integer i :list){
            System.out.println(i);
        }
    }
}
	