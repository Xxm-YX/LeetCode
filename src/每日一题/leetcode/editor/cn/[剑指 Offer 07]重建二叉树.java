package 每日一题.leetcode.editor.cn;

//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归
// 👍 312 👎 0

import java.util.HashMap;
import java.util.Map;

public class ZhongJianErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
        
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {

    /**
     * 递归
     * @param preorder
     * @param inorder
     * @return
     */
    private Map<Integer,Integer> indexMap;

    public TreeNode myBuildTree(
            int[] preorder,//先序遍历
            int[] inorder,//中序遍历
            int preorder_left,//先序遍历左边界
            int preorder_right,//先序遍历右边界
            int inorder_left,//中序 左边界
            int inorder_right//中序 右边界
    ) {
        if(preorder_left > preorder_right){
            return null;
        }
        //前序遍历中的第一个节点，就是根节点
        int preorder_root = preorder_left;
        //在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);


        //先把根节点建立起来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        //得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;

        //递归构造左子树，并连接根节点
        //先序遍历中 「从 左边界+1 开始的 size_left_subtree」个元素就对应了
        // 中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(
                preorder,
                inorder,
                preorder_left + 1,
                preorder_left + size_left_subtree,
                inorder_left,
                inorder_root - 1
        );

        //递归构造右子树，并连接到根节点
        //先序遍历中[从左边界+1+左子树根节点数目，开始到右边界]元素到对应了中序遍历中
        //[从根节点定位+右边界]的元素
        root.right = myBuildTree(
                preorder,
                inorder,
                preorder_left + size_left_subtree + 1,
                preorder_right,
                inorder_root + 1,
                inorder_right
        );
        return root;
    }

       public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int n = preorder.length;
        //构造哈希映射，帮助我们快速定位根节点
           indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i] , i);
        }
        return myBuildTree(preorder, inorder,0 ,n-1, 0 , n-1);
    }

    /***********************************************************************/

    /**
     * 迭代
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}