/**
 * User: Changle
 * Date: 2018-01-31 20:12
 * Description:
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 时间限制：1秒 空间限制：32768K
 */

public class Solution {

    public class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
            return true;
        if(Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) > 1){
            return false;
        }
        boolean left = IsBalanced_Solution(root.left);
        boolean right = IsBalanced_Solution(root.right);
        return left && right;
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left),TreeDepth(root.right)) + 1;
    }
}
