/**
 * User: Changle
 * Date: 2018-02-14 16:10
 * Source: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */
 
 /*
 取出 BST 中的每个元素放到数组中排序，
 
 再求相邻元素之间差值的最小值
*/ 
 public class Solution {
    
    private int[] nodeArr;
    private int size;
    private int index;
    
    public int minDiffInBST(TreeNode root) {
      int result = Integer.MAX_VALUE;
      nodeArr = new int[size(root)];
      fillArray(root);
      Arrays.sort(nodeArr);
      for(int i = 1;i < nodeArr.length;i++){
        result = Math.min(nodeArr[i] - nodeArr[i - 1],result);      
      }
        return result;
    }
    
    private int size(TreeNode root){
        
        if(root == null){
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }
    private void fillArray(TreeNode root){
        if(root == null){
            return;
        }
        nodeArr[index++] = root.val;
        fillArray(root.left);
        fillArray(root.right);
    }
}
