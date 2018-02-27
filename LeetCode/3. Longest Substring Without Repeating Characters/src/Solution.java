import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: Changle
 * Date: 2018-02-21 14:08
 * Source: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */

/*
使用滑动窗口，当新字符不是重复字符时，r 继续移动。
当为重复字符时，将 l 移动到重复字符在 str 中的位置后一位。

时间复杂度: O(n^2)
空间复杂度: O(1)
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        String res = "";
        String str = "";
        while (r < s.length()) {
            char c = s.charAt(r);

            if (str.contains(c + "")) {
                int index = str.indexOf(c);
                l = index + l + 1;
                str = str.substring(index + 1) + c;
                r++;
            } else {
                str = str + c;
                res = (str.length() > res.length()) ? str : res;
                r++;
            }
        }
        return res.length();
    }
}

/*
用 HashSet 来存储出现的字符。
如果新字符没有出现，则加入。
如果新字符为重复字符。那么一直删除 set 中的元素。直到重复的那个字符被删除掉。

时间复杂度: O(n);
空间复杂度: O(len(charset);
 */
class Solution1{
    public static int lengthOfLongestSubstring(String s) {
        int i = 0,j = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(i++);
            }
        }
        return max;
    }
}
