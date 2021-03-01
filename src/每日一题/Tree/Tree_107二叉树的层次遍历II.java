package 每日一题.Tree;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 */
public class Tree_107二叉树的层次遍历II {
    static class TreeNode {
        int val;
        Tree_107二叉树的层次遍历II.TreeNode left;
        Tree_107二叉树的层次遍历II.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * dfs
     * @param root
     * @return
     */
    /*public List<List<Integer>> levelOrderBottom(TreeNode root) {
       if(root == null){
           return new ArrayList<List<Integer>>();
       }
       //结果集
        List<List<Integer>> res = new LinkedList<>();
       dfs(root,res,1);

        Collections.reverse(res);
        return res;
    }

    public void dfs(TreeNode root,List<List<Integer>> res,int level){
        if(root == null){
            return;
        }

        //如果level大于res大小，说明这一层没有对应的集合，需要重新创建
        if(level > res.size()){
            res.add(new ArrayList<>());
        }
        //将当前层的元素直接放到对应层的末尾
        res.get(level-1).add(root.val);

        //继续遍历左右节点

        dfs(root.left,res,level+1);
        dfs(root.right,res,level+1);

    }*/

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        return null;
    }
}
