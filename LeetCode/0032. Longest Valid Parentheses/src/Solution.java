import java.util.Arrays;
import java.util.Stack;

/**
 * @author changleamazing
 * @date 2020/7/4 09:39
 * source: https://leetcode-cn.com/problems/longest-valid-parentheses/
 **/
public class Solution {

    public static void main(String[] args) {
    }

    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                dp[i] = (i - 2 > 0 ? dp[i - 2] : 0) + 2;
            } else if (s.charAt(i) == ')' && s.charAt(i - 1) == ')') {
                if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(0);
    }
}
