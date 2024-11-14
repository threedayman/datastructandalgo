package datastructures;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 队列是一种遵循先入先出逻辑的线性数据结构
 */
public class QueueStruct {
    public static void main(String[] args) {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        queue.offer(4);
        System.out.println("删除元素");
        System.out.println(queue.remove());
        System.out.println("遍历元素");
        queue.forEach(System.out::println);

        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.addFirst(2);
        deque.addLast(3);
        System.out.println(deque.peek());
        System.out.println(deque.pollFirst());
        System.out.println(deque.peekLast());
        System.out.println("遍历元素");
        deque.forEach(System.out::println);
    }
}
