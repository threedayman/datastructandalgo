package datastructures;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author dongwq
 * @date 2025/03/2025/3/13
 **/
public class NodeTest {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n3.left=n5;
        levelOrder(n1);

        System.out.println("前序-----------------------------");
        preOrder(n1);
        System.out.println("中序-----------------------------");
        midOrder(n1);
        System.out.println("后续-----------------------------");
        postOrder(n1);
    }
    //二叉搜索树查询
    public static Node search(Node binarySearchNode,int targetVal){

        if(binarySearchNode==null){
            return null;
        }

        Node cur = binarySearchNode;
        while(cur!=null){
            if(cur.val>targetVal){
                cur=cur.left;
            }else if(cur.val<targetVal){
                cur=cur.right;
            }else {
                return cur;
            }
        }
        return null;
    }

    // 二叉搜索树插入
    public static void insert(Node binarySearchNode,int targetVal){
        if(binarySearchNode==null){
            binarySearchNode = new Node(targetVal);
        }
        Node cur = binarySearchNode;
        Node pre =null;
        while (cur!=null){
            if(cur.val==targetVal){
                return;
            }
            pre = cur;
            if(cur.val<targetVal){
                cur=cur.right;
            }else{
                cur=cur.left;
            }
        }

        Node newNode = new Node(targetVal);
        if(pre.val<targetVal){
            pre.right=newNode;
        }else{
            pre.left=newNode;
        }
    }

    //二叉搜索树删除
    public static void removeItem(Node root,int num){
        if(root==null){
            return;
        }
        Node cur = root;
        Node pre = null;
        while(cur!=null){
            if(cur.val==num){
                break;
            }
            pre =cur;
            if(cur.val>num){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }

        if(cur.left==null||cur.right==null){

            Node child = cur.left!=null?cur.left:cur.right;
            if(pre!=null){
                if(pre.val<num){
                    pre.right=child;
                }else{
                    pre.left=child;
                }
            }
        }else {
            Node tmp = cur.right;
            while (tmp.left!=null){
                tmp=tmp.left;
            }
            removeItem(root,tmp.val);
            cur.val= tmp.val;
        }

    }


    public static void levelOrder(Node node){
        if(node == null){
            return;
        }

        Queue<Node> queue = new ConcurrentLinkedQueue<>();
        queue.add(node);

        while (!queue.isEmpty()){
            Node n = queue.poll();
            System.out.println(n.val);
            if(n.left!=null){
                queue.add(n.left);
            }
            if(n.right!=null){
                queue.add(n.right);
            }
        }
    }


    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }


    public static void midOrder(Node root){
        if(root == null){
            return;
        }
        midOrder(root.left);
        System.out.println(root.val);
        midOrder(root.right);
    }


    public static void postOrder(Node root){
        if(root ==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}
