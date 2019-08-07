package com.atguigu.atcrowdfunding.tree3;
 
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
 
public class BuildTreeTester {
 
    public static void main(String[] args) {
        
        
        List<Tree<Test>> trees = new ArrayList<Tree<Test>>();
        List<Test> tests = new ArrayList<Test>();
        tests.add(new Test("0", "", "关于本人"));
        tests.add(new Test("1", "0", "技术学习"));
        tests.add(new Test("2", "0", "兴趣"));
        tests.add(new Test("3", "1", "JAVA"));
        tests.add(new Test("4", "1", "oracle"));
        tests.add(new Test("5", "1", "spring"));
        tests.add(new Test("6", "1", "springmvc"));
        tests.add(new Test("7", "1", "fastdfs"));
        tests.add(new Test("8", "1", "linux"));
        tests.add(new Test("9", "2", "骑行"));
        tests.add(new Test("10", "2", "吃喝玩乐"));
        tests.add(new Test("11", "2", "学习"));
        tests.add(new Test("12", "3", "String"));
        tests.add(new Test("13", "4", "sql"));
        tests.add(new Test("14", "5", "ioc"));
        tests.add(new Test("15", "5", "aop"));
        tests.add(new Test("16", "1", "等等"));
        tests.add(new Test("17", "2", "等等"));
        tests.add(new Test("18", "3", "等等"));
        tests.add(new Test("19", "4", "等等"));
        tests.add(new Test("20", "5", "等等"));
 
        for (Test test : tests) {
            Tree<Test> tree = new Tree<Test>();
            tree.setId(test.getId());
            tree.setPid(test.getPid());
            tree.setName(test.getText());
//            List<Map<String, Object>> lmp = new ArrayList<Map<String, Object>>();
//            Map<String, Object> mp = new HashMap<String, Object>();
//            mp.put("COSTDEVICE_NUMBER", "");
//            mp.put("PRICE_PER", "");
//            mp.put("ORDER_INDEX", "");
//            mp.put("ADJUST_DATE", "");
//            mp.put("IS_LEAF", "");
//            lmp.add(mp);
//            tree.setAttributes(lmp);
            trees.add(tree);
        }
 
        Tree<Test> t = BuildTree.build(trees);
        System.out.println(t);
        System.out.println("=======================");
        List<Tree<Test>> build2 = BuildTree.build2(trees);
        System.out.println(build2);
        System.out.println("=======================");
        List<Tree<Test>> build3 = BuildTree.build3(trees);
        System.out.println(build3);
    }
}

