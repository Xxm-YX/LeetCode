package 每日一题.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class DFS_404左叶子之和 {
    static class TreeNode {
        int val;
        DFS_404左叶子之和.TreeNode left;
        DFS_404左叶子之和.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //DFS
    /*
    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ?  dfs(root) : 0;
    }

    public int dfs(TreeNode root){
        int ans = 0;
        if (root.left != null) {
            ans += isLeafNode(root.left) ? root.left.val : dfs(root.left);
        }
        if(root.right != null && !isLeafNode(root.right)){
            ans += dfs(root.right);
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node){
        return node.left==null && node.right == null;
    }
    */

    //迭代
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> path = new LinkedList<TreeNode>();
        path.offer(root);

        int ans=0;
        while (!path.isEmpty()) {
            TreeNode node = path.poll();
            if (node.left != null) {
                if(isLeafNode(node.left)){
                    //是叶子节点
                    ans += node.left.val;
                }else{
                    //不是叶子节点
                    path.offer(node.left);
                }
            }
            if (node.right != null) {
                if(!isLeafNode(node.right)){
                    path.offer(node.right);
                }
            }
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node){
        return node.left==null && node.right == null;
    }
}
