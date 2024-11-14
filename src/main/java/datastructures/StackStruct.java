package datastructures;

import java.util.Stack;

/**
 * 栈是一种遵循先入后出逻辑的线性数据结构
 */
public class StackStruct {

    public static void main(String[] args) {
        // 初始化栈
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        //栈顶元素出栈
        System.out.println(s.pop());

        //取出栈顶元素 第一次
        System.out.println(s.peek());
        //取出栈顶元素 第二次
        System.out.println(s.peek());

    }
}
