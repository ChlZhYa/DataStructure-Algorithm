/**
 * @author changleamazing
 * @date 2020/7/12 11:06
 * resource: https://leetcode-cn.com/problems/dungeon-game/
 **/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        solution.calculateMinimumHP(dungeon);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        dp[0][0] = dungeon[0][0] > 0 ? 1 : 1 - dungeon[0][0];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 ) {
                    dp[i][j] = j > 0 ? (dp[i][j - 1]  - (Math.min(dungeon[i][j], 0))) : dp[0][0];
                } else if (j == 0) {
                    dp[i][j] =  dp[i - 1][j]  - (Math.min(dungeon[i][j], 0));
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) - (Math.min(dungeon[i][j], 0));
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
