/**
 * User: Changle
 * Date: 2018-02-27 19:38
 * Source: https://leetcode.com/problems/minimum-window-substring/description/
 */

/*
使用滑动指针。
j指针向右移动，当 count == 0 时表示所有 t 中的字符已经出现过一次。
此时滑动 i 指针。直到 i 指针移动到一个该在 t 中出现的字符为止。

时间复杂度：O(len(s) + len(t))
空间复杂度：O(1)
 */
public class Solution {

    public static String minWindow(String s, String t) {
        int[] ch = new int[256];
        for (char c : t.toCharArray()) {
            ch[c]++;
        }

        int i = 0, j = 0;
        int count = t.length();
        int min = s.length() + 1;
        int start = 0;
        while (j < s.length()) {
            if (ch[s.charAt(j++)]-- > 0) {
                count--;
            }

            while (count == 0) {
                if (j - i < min) {
                    min = j - i;
                    start = i;
                }

                if (ch[s.charAt(i++)]++ >= 0) {
                    count ++;
                }
            }
        }

        return min == s.length() + 1 ? "" : s.substring(start, min + start);
    }
}
