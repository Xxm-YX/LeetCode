package 每日一题.Tree;

/**
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1

 */
public class Tree_226翻转二叉树 {
    public static class TreeNode {

        int val;
        public Tree_226翻转二叉树.TreeNode left;
        public Tree_226翻转二叉树.TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
    /**
     * BFS
     */
    /*public TreeNode invertTree(TreeNode root) {
        //使用队列
        if (root == null) {
            return root;
        }
        Queue<TreeNode> path = new LinkedList<>();

        path.offer(root);
        while (!path.isEmpty()) {
            TreeNode node = path.poll();

            //直接交换
            if(node.left != null || node.right!= null){
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }

            if (node.left != null) {
                path.offer(node.left);
            }
            if (node.right != null) {
                path.offer(node.right);
            }
        }
        return root;
    }*/

    /**
     * DFS
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
}
