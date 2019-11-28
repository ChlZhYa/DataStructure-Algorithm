import java.util.Arrays;

/**
 * @author Changle
 * @date 2019/11/28 15:16
 * source: https://leetcode.com/problems/zigzag-conversion/
 */

public class Solution {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // 创建每一行的数组
        String[] result = new String[numRows];
        Arrays.fill(result, "");
        for (int i = 0; i < s.length(); i++) {
            // 获取当前字符在所在 Z 字中的索引
            int index = i % (2 * numRows - 2);
            String curChar = String.valueOf(s.charAt(i));
            if (index < numRows) {
                result[index] += curChar;
            } else {
                result[2 * numRows - 2 - index] += curChar;
            }
        }

        StringBuilder reString = new StringBuilder();
        for (String value : result) {
            reString.append(value);
        }
        return reString.toString();

    }

}
