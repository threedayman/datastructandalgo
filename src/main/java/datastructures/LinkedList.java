package datastructures;

/**
 * 链表是一种线性数据结构，其中每个元素都是一个节点对象，各个节点之间通过“引用”相链接。
 * 除了保存数据外，链表节点还需要额外保存一个引用，所以相同数据量情况下，链表比数组更占内存空间。
 * 链表数据分配可以在非连续得内存空间中。
 * 本例展示了初始化链表、插入节点、删除节点、访问节点、查找节点
 */
public class LinkedList {

    public static void main(String[] args) {
        //初始化链表
        Node head = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(5);
        Node node3 = new Node(6);
        Node node4 = new Node(8);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        System.out.println(head);

        //插入节点
        Node nodex = new Node(4);
        insertNode(node1,nodex);
        System.out.println(head);

        //删除节点
        deleteNode(node1);
        System.out.println(head);

        //访问节点
        System.out.println("访问节点");
        System.out.println(accessNode(head,3));

        //查找节点
        System.out.println("查找节点");
        System.out.println(searchNode(head,6));
        System.out.println(searchNode(head,10));
    }

    public static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value=value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public static void insertNode(Node cur,Node target){
        Node next = cur.next;
        cur.next=target;
        target.next=next;
    }

    public static void deleteNode(Node cur){
        if(cur==null||cur.next==null){
            return;
        }
        cur.next = cur.next.next;
    }

    public static Node accessNode(Node head,int index){

        for(int i=0;i<index;i++){
            if(head==null){
                return null;
            }
            head = head.next;
        }
        return head;
    }

    public static int searchNode(Node head,int target){
       int index =0;
        while(head != null){
            if(head.value==target){
                return index;
            }
            head = head.next;
            index++;
        }
        return -1;
    }

}
