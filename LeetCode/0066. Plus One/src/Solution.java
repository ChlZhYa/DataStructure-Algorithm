import java.util.Arrays;

/**
 * @author Changle
 * @date 2019/9/30 15:48
 * source: https://leetcode.com/problems/plus-one/
 */

public class Solution {

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        //如果 digits 第 1 位为 0，那么后面的所有位都为 0，只需要将进位赋值到新数组的第 1 位即可
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
