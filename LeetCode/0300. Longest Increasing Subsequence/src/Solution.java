/**
 * 最长递增子序列
 * @author: changle
 * @time: 2019/9/28 02:47
 * source:  https://leetcode.com/problems/longest-increasing-subsequence/
 */

/**
 * dp
 * O(n) : n^2
 */
public class Solution {

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int result = 1;
        int[] dp = new int[nums.length];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (dp[i] <= dp[j] && nums[i] > nums[j]) {
                    dp[i] = dp[j] + 1;
                    if (dp[i] > result ) {
                        result = dp[i];
                        break;
                    }
                }
            }
        }
        return result;
    }

}
