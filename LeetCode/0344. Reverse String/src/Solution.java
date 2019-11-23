/**
 * User: Changle
 * Date: 2018-02-19 00:06
 * Source: https://leetcode.com/problems/reverse-string/description/
 */

/**
 * 使用对撞指针。交换相对位置的字符。
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
public class Solution {

    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}

