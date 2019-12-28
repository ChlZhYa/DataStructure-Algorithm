/**
 * @author changleamazing
 * @date 2019/12/29 00:29
 * source: https://leetcode-cn.com/problems/deepest-leaves-sum/
 **/
public class Solution {

    int maxDepth, res;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (depth == maxDepth) {
                res += root.val;
            } else if (depth > maxDepth) {
                maxDepth = depth;
                res = root.val;
            }
        } else {
            dfs(root.left, depth + 1);
            dfs(root.right, depth + 1);
        }
    }
}
