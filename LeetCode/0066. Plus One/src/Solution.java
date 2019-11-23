/**
 * @author changleamazing
 * @date 2019/11/23 12:01
 * source: https://leetcode.com/problems/plus-one/
 **/
public class Solution {
    public static int[] plusOne(int[] digits) {

        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + (i == digits.length - 1 ? 1 : sum / 10);
            digits[i] = sum % 10;
            if (sum < 10) {
                return digits;
            }
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        System.arraycopy(digits, 0, result, 1, result.length - 1);
        return result;
    }
}
