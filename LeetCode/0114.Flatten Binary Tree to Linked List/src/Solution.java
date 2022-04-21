class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        merge(root);
    }

    public TreeNode merge(TreeNode node){
        if(node == null){
            return null;
        }
        TreeNode leftEnd =  merge(node.left);
        TreeNode rightEnd = merge(node.right);
        if(leftEnd != null){
            leftEnd.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        return rightEnd == null ? (leftEnd == null ? node : leftEnd) : rightEnd;
    }
}