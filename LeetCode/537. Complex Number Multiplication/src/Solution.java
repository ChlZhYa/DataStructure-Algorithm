/**
 * User: Changle
 * Date: 2017-11-06 10:10
 * -------------------------------------------------------------------------------------------------------------------
 * Description:
 * Given two strings representing two complex numbers.
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2:
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 */

public class Solution {

    public String complexNumberMultiply(String a, String b) {
        String[] x = a.split("\\+|i");
        String[] y = b.split("\\+|i");
        int x0 = Integer.parseInt(x[0]);
        int x1 = Integer.parseInt(x[1]);
        int y0 = Integer.parseInt(y[0]);
        int y1 = Integer.parseInt(y[1]);

        String res = x0 * y0 - x1 * y1 + "+" + (x0 * y1 + x1 * y0) + "i";
        return res;

    }
}