/**
 * @author Changle
 * @date 2019/2/26 11:06
 * @source: https://leetcode.com/problems/construct-string-from-binary-tree/submissions/
 */

class Solution {

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        String root = t.val + "";
        String left = (t.right == null && t.left == null) ? "" : ("(" + tree2str(t.left) + ")");
        String right = (t.right == null) ? "" : ("(" + tree2str(t.right) + ")");

        return root + left + right;
    }
}
