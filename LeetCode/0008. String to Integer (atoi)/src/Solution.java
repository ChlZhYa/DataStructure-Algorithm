/**
 * @author Changle
 * @date 2019/11/28 18:32
 * source: https://leetcode.com/problems/string-to-integer-atoi/
 */

public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') i++;
        if (i == str.length()) return 0;
        int sign = 1;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            if (str.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }
        if (i >= str.length() || !isDigit(str.charAt(i))) {
            return 0;
        }
        long val = 0L;
        while (i < str.length() && isDigit(str.charAt(i))) {
            val = val * 10 + str.charAt(i) - '0';
            long temp = sign * val;
            if (temp < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (temp > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            i++;
        }

        return (int) (val * sign);
    }
    private static boolean isDigit(char ch) {
        return (ch >= '0' && ch <= '9');
    }

}
