package 每日一题.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
public class Tree_117填充每个节点的下一个右侧节点指针II {

    static class Node{
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
                val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
                val = _val;
                left = _left;
                right = _right;
                next = _next;
        }
    }

    public static Node connect(Node root) {
        if(root == null){
            return null;
        }

        Queue<Node> path = new LinkedList<>();
        path.offer(root);
        while(!path.isEmpty()){
            Node last = null;
            int n = path.size();
            for (int i = 1 ; i<= n ; i++){
                Node temp = path.poll();
                if(temp.left!=null){
                    path.offer(temp.left);
                }

                if(temp.right!= null){
                    path.offer(temp.right);
                }

                if (i != 1) {
                    last.next = temp;
                }
                last = temp;
            }

        }
        return root;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(2);
        a.right =new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);
        a.right.left = new Node(6);
        a.right.right = new Node(7);

        connect(a);
    }
}
