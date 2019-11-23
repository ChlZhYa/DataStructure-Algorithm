/**
 * @author changleamazing
 * @date 2019/11/23 12:05
 * source: https://leetcode.com/problems/decode-ways/
 **/
public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) != '0') ? 1 : 0;
        for(int i = 2;i <= n;i++){
            int last = Integer.valueOf(s.substring(i - 1,i));
            int lastTwo = Integer.valueOf(s.substring(i - 2,i));
            if(last >= 1 && last <= 9){
                dp[i] += dp[i - 1];
            }
            if(lastTwo >= 10 && lastTwo <= 26){
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}