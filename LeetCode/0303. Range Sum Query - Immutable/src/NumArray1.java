/**
 * @author Changle
 * @date 2019/3/11 15:35
 * source: https://leetcode.com/problems/range-sum-query-immutable/
 */

class NumArray {

   private int[] sumArray;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            sumArray = new int[nums.length];
            sumArray[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sumArray[i] = sumArray[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (sumArray.length <= 0) {
            return 0;
        }

        if(i == 0){
            return sumArray[j];
        }
        return sumArray[j] - sumArray[i - 1];
    }
    
}
