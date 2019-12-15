/**
 * @author changleamazing
 * @date 2019/12/15 12:55
 * source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 **/
public class Solution {

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) {
            return maxProfitWithInf(prices);
        }

        int[][][] dp = new int[len][k + 1][2];
        for (int i = 0; i < len; i++) {
            // 这里不需要初始化的原因是状态转移方程只会依赖到 dp[i - 1][0][0]。而 dp[i - 1][0][0] 默认就是 0，不需要再初始化
            // dp[i][0][0] = 0;
            // dp[i][0][1] = Integer.MIN_VALUE;

            // j 表示最多买入次数
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[0];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
        }
        return dp[len - 1][k][0];
    }

    private int maxProfitWithInf(int[] prices) {
        int dayiWithoutHold = 0;
        int dayiWithHold = Integer.MIN_VALUE;

        for (int price : prices) {
            int temp = dayiWithoutHold;
            dayiWithoutHold = Math.max(temp, dayiWithHold + price);
            dayiWithHold = Math.max(dayiWithHold, temp - price);
        }
        return dayiWithoutHold;
    }
}
