/**
 * @author Changle
 * @date 2018/10/30 11:52
 */

public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] memo = new int[n];
        memo[n - 1] = nums[n - 1];
        for(int i = n - 2;i >= 0;i--){
            memo[i] = Math.max(memo[i + 1],nums[i] + (i + 2 < n ? memo[i + 2] : 0));
        }
        return memo[0];
    }
}
