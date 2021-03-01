package 每日一题.Tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。

 */


public class Tree_637二叉树的层平均值 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * DFS解法
     */
    /*public List<Double> averageOfLevels(TreeNode root) {
       List<Integer> counts = new ArrayList<>(); //每一层的数量
       List<Double> sums = new ArrayList<>();    //每一层的总和

       dfs(root,0,counts,sums);

       List<Double> averages = new ArrayList<>();
       int size = sums.size();                    //总层数
        for (int i = 0; i < size; i++) {
            averages.add(sums.get(i)/ counts.get(i));
        }
        return averages;
    }

    public void dfs(TreeNode root , int level,List<Integer> counts, List<Double> sums){
        if(root == null){
            return;
        }

        if( level < sums.size()){
            sums.set(level , sums.get(level) + root.val);
            counts.set(level,counts.get(level) + 1);
        }else {
            //第0层，顶点
            sums.add(1.0*root.val);
            counts.add(1);
        }
        dfs(root.left,level+1,counts,sums);
        dfs(root.right,level+1,counts,sums);
    }*/

    /**
     * 队列，弹出来一个，进去两个
     * BFS
     */

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0; //总和
            int size = queue.size(); //队列的总数量，
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            res.add(sum / size);
        }
        return res;
    }






}
