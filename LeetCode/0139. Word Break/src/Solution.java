import java.util.Arrays;
import java.util.List;

/**
 * @author changleamazing
 * @date 2019/12/24 00:14
 * source: https://leetcode.com/problems/word-break/
 **/
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] 表示 s.substring(0,i) 是否能被拆分
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("cars", Arrays.asList("car", "ca", "rs")));
    }
}
