import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author changleamazing
 * @date 2019/12/28 17:56
 * source: https://leetcode.com/problems/binary-tree-paths/
 **/
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if(root==null) return ret;
        solve(root, "", ret);
        return ret;
    }
    public void solve(TreeNode root, String cur, List<String> ret){
        if(root==null) return;
        cur += root.val;
        if(root.left==null&&root.right==null){
            ret.add(cur);
        }else{
            solve(root.left, cur+"->", ret);
            solve(root.right, cur+"->", ret);
        }
    }
}