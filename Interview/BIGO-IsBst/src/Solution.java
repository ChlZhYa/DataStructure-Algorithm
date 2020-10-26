/**
 * @author changleamazing
 * @date 2020/10/26 20:26
 **/
public class Solution {

    static boolean isBST = true;

    /**
     * 是否是二叉搜索树
     * @param node
     * @return
     */
    private boolean isBinarySearchTree(TreeNode node) {
        recursive(node);
        return isBST;
    }

    /**
     * 递归遍历节点
     * @param node
     */
    private void recursive(TreeNode node) {
        if (node == null) {
            return;
        }
        // 左节点不为空且大于等于父节点，则修改标识
        if (node.left != null && node.left.val >= node.val) {
            isBST = false;
        }
        recursive(node.left);
        // 右节点不为空且小于等于父节点，则修改标识
        if (node.right != null && node.right.val <= node.val) {
            isBST = false;
        }
        recursive(node.right);
    }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
