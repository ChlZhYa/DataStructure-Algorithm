/**
 * User: Changle
 * Date: 2018-02-14 16:10
 * Source: https://leetcode.com/problems/valid-palindrome/description/
 */

/**
 * 对撞指针判断对称的两个字符，如果是特殊符号则继续移动。
 *
 * 依次判断。当 两个指针相遇时，说明这个字符串是回文串。
 */
public class Solution {

    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            char chari = s.charAt(i);
            char charj = s.charAt(j);
            if (!Character.isLetterOrDigit(chari)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(charj)) {
                j--;
                continue;
            }
            if (Character.toUpperCase(chari) != Character.toUpperCase(charj)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
