package datastructures;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 数组是一种线性数据结构，将相同元素存储在连续得内存空间中。
 * 代码演示了 数组初始化、访问数组元素、指定位置插入数组元素、删除指定位置元素、遍历数据、查找数据位置、数组扩容
 */
public class Array {
    public static void main(String[] args) {
        //初始化数组 1
        int[] array = {0,1,2,3};
        System.out.println(Arrays.toString(array));
        //初始化数组 2
        int[] array2 = new int[5];
        System.out.println(Arrays.toString(array2));

        //访问数组元素
        System.out.println(array[0]);

        //指定位置插入元素
        insert(4,2,array);
        System.out.println(Arrays.toString(array));

        //删除指定位置元素
        delete(array,0);
        System.out.println(Arrays.toString(array));

        //遍历数组1
        System.out.println("第一次遍历");
        for(int i:array){
            System.out.println(i);
        }
        Arrays.stream(array).forEach(System.out::println);

        //遍历数组2
        System.out.println("第二次遍历");
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }

        //数组中查找
        System.out.println("查找索引位置");
        System.out.println(search(4,array));
        System.out.println(search(2,array));
        System.out.println(search(8,array));

        //数组扩容
        System.out.println("数组扩容");
        System.out.println(Arrays.toString(extend(array)));

    }

    public static void insert(int value,int index,int[] array){
        if(array==null||array.length<=index){
            return;
        }

        for(int i=index+1;i<array.length;i++){
            array[i]=array[i-1];
        }
        array[index] = value;
    }

    public static void delete(int[] array,int index){
        if(array==null||array.length<=index){
            return;
        }
        for(int i=index;i<array.length-1;i++){
            array[i]=array[i+1];
        }
        array[array.length-1]=0;
    }

    public static int search(int target,int[] array){
        if(array==null){
            return -1;
        }

        for(int i=0;i<array.length;i++){
            if(array[i]==target){
                return i;
            }
        }
        return -1;
    }

    public static int[] extend(int[] array){
        if(array==null){
            return new int[10];
        }
        int targetLength = array.length*2;
        return Arrays.copyOf(array,targetLength);
    }
}
