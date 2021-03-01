package 每日一题.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 */
public class Tree_144二叉树的前序遍历 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    /**
     * 递归 简单
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if( root == null){
            return null;
        }

        List<Integer> res = new ArrayList<>();

        dfs(res,root);
        
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root) {
        if(root == null){
            return;
        }

        res.add(root.val);
        dfs(res,root.left);
        dfs(res,root.right);
    }

    /**
     * 迭代 一般 使用栈
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return  res;
        }

        Deque<TreeNode> path = new LinkedList<>();
        TreeNode node = root;

        while(!path.isEmpty() || node != null){
            while(node != null){
                res.add(node.val);
                path.push(node);
                node = node.left;
            }

            node = path.poll();
            node = node.right;
        }
        return res;
    }

    /**
     * Morris 遍历
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        TreeNode p1 = root,p2 = null;

        while(p1 != null){
            p2 = p1.left;
            if(p2!= null){
                //首先对当前节点 进行右子节点的前驱绑定
                while(p2.right != null && p2.right != p1){
                    p2 = p2.right;
                    //这个地方 弹出去之后 就说明已经到了最右子节点
                }
                //这个地方 关键 进行前驱绑定
                if(p2.right == null){
                    res.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    //往左走
                    continue;
                }else {
                    //说明已经绑定了，开始解绑
                    p2.left = null;
                }
            }else {
                //当前p1节点是左子节点
                res.add(p1.val);
            }
            //返回前驱子节点
            p1 = p1.right;
        }
        return res;
    }
}
