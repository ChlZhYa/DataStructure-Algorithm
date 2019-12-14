/**
 * @author changleamazing
 * @date 2019/12/14 12:01
 * source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 **/
class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //    今天持有股票有两种情况
            //    1. 昨天持有，今天冷冻，即 dp[i - 1][0]
            //    2. 今天买入，则昨天必然是未持有且冷冻，而 dp[i - 1][0] 无法代表昨天是冷冻状态。继续回顾前天，由于 i - 1 天未持有且冷冻，则 i - 2 天一定为未持有的状态，无论当天是卖出还是保持冷冻，都对应 dp[i - 2][0]
            if (i < 2) {
                dp[i][1] = Math.max(-prices[i - 1], -prices[i]);
            } else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }
        }

        return dp[len - 1][0];
    }
}
