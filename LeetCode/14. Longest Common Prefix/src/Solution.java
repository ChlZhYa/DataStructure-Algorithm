import java.util.Arrays;

/**
 * @author: changle
 * @time: 2019-06-13 21:56
 * source: https://leetcode.com/problems/longest-common-prefix/
 */
public class Solution {


    public  String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String firstStr = strs[0];
        for (int i = 1; i <= firstStr.length(); i++) {
            String prefix = firstStr.substring(0, i);
            if (Arrays.stream(strs).skip(1).anyMatch(str -> !str.startsWith(prefix))) {
                return prefix.substring(0, i - 1);
            }
        }
        return firstStr;
    }

}
