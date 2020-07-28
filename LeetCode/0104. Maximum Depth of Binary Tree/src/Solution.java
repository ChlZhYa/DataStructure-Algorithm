/**
 * User: Changle
 * Date: 2020-07-28 10:20
 * Source: https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
 
 class Solution {

    private int maxDepth = 0;

    public int maxDepth(TreeNode root) {
            if(root == null)
                return 0;
            findDepth(root,0);
            return maxDepth;
    }

    private void findDepth(TreeNode root,int depth){
        if(root != null){
            findDepth(root.left, depth + 1);
            findDepth(root.right,depth + 1);
        }else{
            maxDepth = Math.max(depth,maxDepth);
        }
    }
}
