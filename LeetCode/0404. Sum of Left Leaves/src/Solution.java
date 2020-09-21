

/**
 * @author changleamazing
 * @date 2020/9/20 10:10
 **/
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return recursive(root);
    }

    private int recursive(TreeNode root){
        int res = 0;
        if(root == null){
            return 0;
        }
        if(root.left != null && root.left.left == null && root.left.right == null){
            res += root.left.val;
        }
        res += recursive(root.left);
        res += recursive(root.right);
        return res;
    }
}
