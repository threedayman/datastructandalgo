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

    public static Node search1(Node root,int targetVal){
        if(root==null){
            return null;
        }
        Node cur = root;
        while (cur !=null){
            if(cur.val==targetVal){
                return cur;
            }else if(cur.val<targetVal){
                cur=cur.right;
            }else{
                cur=cur.left;
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

    public static void insert1(Node root,int targetVal){
        if(root ==null){
            root = new Node(targetVal);
            return;
        }

        Node pre = null;
        Node cur = root;
        while(cur!=null){
            if(cur.val==targetVal){
                return;
            }
            pre = cur;
            if(cur.val<targetVal){
                cur=cur.right;
            }else {
                cur=cur.left;
            }
        }
        Node insertNode = new Node(targetVal);
        if(pre.val<targetVal){
            pre.right=insertNode;
        }else {
            pre.left=insertNode;
        }

    }

    /**
     * 我们根据目标节点的子节点数量，分0、1 和2 三种情况，执行对应的删除节点操作
     * 1.当待删除节点的度为0 时，表示该节点是叶节点，可以直接删除
     * 2.当待删除节点的度为1 时，将待删除节点替换为其子节点即可
     * 3.当待删除节点的度为2 时，我们无法直接删除它，而需要使用一个节点替换该节点。由于要保持二叉搜索树
     * “左子树< 根节点< 右子树”的性质，因此这个节点可以是右子树的最小节点或左子树的最大节点
     * @date 2025/3/27
     **/
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


    public static void removeItem1(Node root,int num){
        if(root==null){
            return;
        }
        Node cur = root;
        Node pre = null;
        while(cur!=null){
            if(cur.val==num){
                break;
            }
            pre = cur;
            if(cur.val<num){
                cur=cur.right;
            }else {
                cur=cur.left;
            }
        }
        if(cur==null){
            return;
        }
        if(cur.left==null||cur.right==null){
            Node child = cur.left!=null ? cur.left:cur.right;
            if(pre.val<num){
                pre.right=cur;
            }else {
                pre.left=cur;
            }
        }else{
            Node tmp = cur.right;
            while(tmp.left!=null){
                tmp=tmp.left;
            }
            cur.val= tmp.val;
            removeItem1(root,tmp.val);
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
