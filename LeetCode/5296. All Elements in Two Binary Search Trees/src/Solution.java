import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author changleamazing
 * @date 2019/12/29 10:43
 * source: https://leetcode-cn.com/contest/weekly-contest-169/problems/all-elements-in-two-binary-search-trees/
 **/
public class Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> list = new ArrayList<>();
        dfs(root1, list);
        dfs(root2, list);
        list.sort(Comparator.comparingInt(o -> o));
        return list;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        dfs(node.left, list);
        dfs(node.right, list);
    }
}
