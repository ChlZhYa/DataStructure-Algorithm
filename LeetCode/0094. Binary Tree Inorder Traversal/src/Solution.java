import java.util.ArrayList;
import java.util.List;

/**
 * @author changleamazing
 * @date 2020/9/28 17:52
 * source: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 **/
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        inorderTraversal(root, resList);
        return resList;
    }

    private void inorderTraversal(TreeNode root, List<Integer> resList) {

    }
}
