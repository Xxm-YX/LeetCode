package 每日一题.Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 */
public class Tree_501二叉搜索树中的众数 {
    public static class TreeNode {

        int val;
        public Tree_501二叉搜索树中的众数.TreeNode left;
        public Tree_501二叉搜索树中的众数.TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
    int[] a = new int[10000000];
    Map<Integer,Integer> b = new HashMap<>();
    public int[] findMode(TreeNode root) {

        if(root == null ){
            return new int []{};
        }

        dfs(root);

        int max = 0;
        int temp =0;
        int value=0;
        for(int key:b.keySet()){
            value = b.get(key);
            if(max<value){
                max = value;
                temp = key;
            }else if(max == value){

            }
        }

        a[0] = temp;
        int i =1;
        for(int key:b.keySet()){
            value = b.get(key);
            if(max==value && key != a[0]){
                a[i++] = key;
            }
        }
        return Arrays.copyOf(a,i);
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }

        if( b.putIfAbsent(root.val,1) != null){
            b.put(root.val,b.get(root.val)+1);
        }

        dfs(root.left);
        dfs(root.right);


    }
}
