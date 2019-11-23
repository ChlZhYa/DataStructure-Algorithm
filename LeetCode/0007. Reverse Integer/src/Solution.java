/**
 * @author changleamazing
 * @date 2019/11/23 11:55
 * source: https://leetcode.com/problems/reverse-integer/
 **/
public class Solution {

    public int reverse(int x) {

        if (x == 0) {
            return 0;
        }
        boolean negative = x < 0 ? true : false;
        x = x < 0 ? -x : x;
        int reverse = 0;

        while (x > 0) {
            if (reverse > Integer.MAX_VALUE / 10) {
                return 0;
            }
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }

        return negative ? -reverse : reverse;
    }
}
