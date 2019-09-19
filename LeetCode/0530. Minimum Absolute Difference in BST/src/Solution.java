/**
 * User: Changle
 * Date: 2019-1-18 10:11
 * Source: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
 
 /*
 中序遍历，结果出现在相邻元素之间的差值之间。
 */
 
public class Solution {
    private int min = Integer.MAX_VALUE;
    private int prev = -1;
        
    public int getMinimumDifference(TreeNode root) {
       
        inOrder(root);
        return min;
       
    }
    
    private void inOrder(TreeNode root){
        if ( root == null )
            return;
        inOrder(root.left);
        if ( prev != -1 )
            min = Math.min(min,root.val - prev);
        prev = root.val;
        inOrder(root.right);
    }
}
