/**
 * @author: changle
 * @time: 2019/9/26 03:06
 * resource: https://leetcode.com/problems/house-robber/
 */
public class Solution2 {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        };

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1;i < nums.length;i++){
            dp[i] = Math.max(dp[i - 1],(i - 2 < 0 ? nums[i] : (dp[i - 2] + nums[i])));
        }
        return dp[nums.length - 1];
    }
}
