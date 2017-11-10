
/**
 * User: Changle
 * Date: 2017-11-07 09:11
 * -------------------------------------------------------------------------------------------------------------------
 * Description:
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 * <p>
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 * <p>
 * 6
 * /   \
 * 3     5
 * \   /
 * 2 0
 * \
 * 1
 */


public class Solution {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) {
            return null;
        }

        return build(nums, 0, nums.length);
    }

    public TreeNode build(int[] nums, int start, int end) {

        if (start >= end) {
            return null;
        }

        int idOfMax = start;
        for (int i = start + 1; i < end; i++) {
            if (nums[i] > nums[idOfMax]) {
                idOfMax = i;
            }
        }

        TreeNode root = new TreeNode(nums[idOfMax]);

        root.left = build(nums, start, idOfMax);
        root.right = build(nums, idOfMax + 1, end);

        return root;
    }


}
