/**
 * @author Changle
 * @date 2019/1/21 11:16
 * Source: https://leetcode.com/problems/search-in-a-binary-search-tree/
 */

public class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
