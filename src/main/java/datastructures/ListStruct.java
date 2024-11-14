package datastructures;

import java.util.*;

/**
 * 列表是一种抽象的数据结构概念，它表示元素的有序集合，支持元素访问、修改、添加、删除、遍历等操作，无需使用者考虑容量限制的问题。
 * 本例展示了初始化列表，列表元素访问、插入、删除、遍历、拼接、排序等操作。
 */
public class ListStruct {
    public static void main(String[] args) {
        //初始化列表
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);

        //访问列表中元素
        System.out.println(list.get(0));
        System.out.println(list.get(1));

        //插入元素
        list.add(3,4);
        System.out.println("插入元素后结果");
        list.forEach(System.out::print);

        //删除元素
        list.remove(3);
        System.out.println();
        System.out.println("删除元素后结果");
        list.forEach(System.out::print);

        //遍历元素
        System.out.println();
        System.out.println("遍历元素");
        list.forEach(t -> System.out.println(t));

        //遍历元素2
        System.out.println("遍历元素2");
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        //遍历元素3
        System.out.println("遍历元素3");
        for(Integer a : list){
            System.out.println(a);
        }

        //拼接列表
        List<Integer> list1 = new ArrayList<>();
        list1.add(100);
        list1.add(101);
        list.addAll(list1);
        System.out.println("拼接后结果");
        list.forEach(System.out::println);

        //排序列表
        list.set(0,105);
        list.sort(Comparator.reverseOrder());
        System.out.println("输出排序后的list");
        list.forEach(System.out::println);
        Collections.sort(list,Comparator.reverseOrder());

        System.out.println(Arrays.toString(list.stream().filter((t)-> t>100).toArray()));


    }
}
