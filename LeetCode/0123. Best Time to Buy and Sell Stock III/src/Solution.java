/**
 * @author changleamazing
 * @date 2019/12/15 11:29
 * source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 **/
public class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }

        int[][][] dp = new int[len][3][2];
        for (int i = 0; i < len; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
            // j 表示最多买入次数
            for (int j = 1; j <= 2; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[0];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
        }
        return dp[len - 1][2][0];
    }


}
