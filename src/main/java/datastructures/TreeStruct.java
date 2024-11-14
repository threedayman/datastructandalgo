package datastructures;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 根节点  二叉树的顶层的节点，没有父节点
 * 叶子节点 没有子节点的节点
 * 树高度  从根节点到最远节点所经过边的数量
 * 节点高度    该节点到最远节点所经过的边数量
 * 节点所在层级 从顶至底递增，根节点所在层为1
 * 节点的度 节点拥有的子节点数量，取值范围为0，1，2
 * 节点的深度 根节点到此节点经过的边的数量
 * 边 连线两个节点之间的线段
 *
 *  完美二叉树，所有层的节点都被填满，除了叶子节点，其他节点的度都是2，也就是同时拥有左右子节点。
 *  完全二叉树，只有底层节点未被填满，都被填满了。假设n是最底层，那么 n-2层开始 以上节点的度都是2.
 *  完满二叉树，除了叶节点，其他节点的度都为2，跟完美二叉树的区别是不是所有层的节点都被填满。
 *  平衡二叉树，任意节点的左子树和右子树高度差绝对值不超过1
 *
 *  二叉树的退化，当所有层的节点都填满时达到完美二叉树，当所有节点都偏向 一侧，二叉树就退化为链表
 *
 *  二叉树的遍历包括层序遍历、前序遍历、中序遍历、后序遍历。
 *  其中 层序遍历是广度优先算法的一种， 其他则为深度优先算法的视线
 *
 *  二叉搜索树 满足一下条件
 *  1.对于根节点，左子树中所有的节点的值<根节点的值<右子树中所有节点的值。
 *  2.任意节点的左右子树也是二叉搜索树，即同样满足条件1.
 */
public class TreeStruct {
    public static void main(String[] args) {
        //初始化二叉树
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;

        //插入节点
        Node x = new Node(0);
        n1.left=x;
        x.left = n2;

        //删除节点
        n1.left=n2;

        //树的遍历 层级遍历,广度优先
        System.out.println("层级遍历：输出树的内容");
        levelOrder(n1);

        //树的遍历 前序遍历 深度优先
        System.out.println("前序遍历，输出树的内容");
        preOrder(n1);


        //树的遍历 中序遍历 深度优先
        System.out.println("中序遍历，输出树的内容");
        inOrder(n1);

        //树的遍历 后续遍历 深度优先
        System.out.println("后续遍历，输出树的内容");
        postOrder(n1);

        //假设当前的结构是二叉搜索树
        //初始化二叉树
        Node n11 = new Node(1);
        Node n22 = new Node(2);
        Node n33 = new Node(3);
        Node n44 = new Node(4);
        Node n55 = new Node(5);
        n33.left = n22;
        n22.left = n11;
        n33.right=n44;
        n44.right=n55;
        System.out.println("层级遍历");
        levelOrder(n33);
        System.out.println("在树中寻找值为5的节点");
        System.out.println(search(n33,5));

        // 二叉搜索树中插入节点
        inser(n33,8);
        System.out.println("层级遍历");
        levelOrder(n33);

        //二叉树搜索树中删除节点
        remove(n33,3);
        System.out.println("层级遍历");
        levelOrder(n33);

        //二叉搜索树的中序遍历 输出升序数据
        System.out.println("输出升序数据");
        inOrder(n33);


    }

    public static void levelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> queue = new ConcurrentLinkedQueue();
        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }

    }
    //前序遍历顺序 父节点 → 左节点 → 右节点
    public static void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历 左子树→父节点→右子树
    public static void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }
    //后续遍历顺序 左子树→右子树→根节点
    public static void postOrder(Node node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }

    public static Node search(Node node,int num){

        while(node!=null){
            if(node.val<num){
                node = node.right;
            }else if(node.val>num){
                node = node.left;
            }else{
                break;
            }
        }
        return node;
    }

    public static void inser(Node node,int num){
        if (node==null){
            return;
        }
        Node pre = null;

        while(node!=null){
            if(node.val==num){
                return;
            }
            pre = node;
            if(node.val<num){
                node = node.right;
            }else{
                node = node.left;
            }
        }
        if(pre.val<num){
            pre.right=new Node(num);
        }else{
            pre.left = new Node(num);
        }
    }

    public static void remove(Node node,int num){
        if(node==null){
            return;
        }
        Node cur = node;
        Node pre=null;
        while(cur!=null){
            if(cur.val==num){
                break;
            }
            pre = node;
            if(cur.val<num){
                cur=cur.right;
            }else{
                cur=cur.left;
            }
        }

        if(cur.left==null||cur.right==null){
            Node tagert = cur.left==null?cur.right:cur.left;
            if(pre==null){
                cur = tagert;
            }else{
                if(pre.right==cur){
                    pre.right=tagert;
                }else{
                    pre.left=tagert;
                }
            }
        }else{
            Node tmp = node.right;
            while(tmp.left!=null){
                tmp = tmp.left;
            }
            remove(node,tmp.val);
            node.val= tmp.val;

        }
    }

    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
}
