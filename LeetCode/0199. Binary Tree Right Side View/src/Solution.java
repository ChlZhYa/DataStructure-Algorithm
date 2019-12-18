import java.util.ArrayList;
import java.util.List;

/**
 * @author Changle
 * @date 2019/12/18 18:15
 * source: https://leetcode.com/problems/binary-tree-right-side-view/
 */
 
 class Solution {

    int maxDepth = 0;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        backtracing(root, 1, res);
        return res;
    }

    private void backtracing(TreeNode root, int depth, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (depth > maxDepth) {
            list.add(root.val);
            maxDepth = depth;
        }
        backtracing(root.right, depth + 1, list);
        backtracing(root.left, depth + 1, list);
    }
}
