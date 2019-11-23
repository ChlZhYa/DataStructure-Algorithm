import java.util.HashMap;
import java.util.Map;

/**
 * User: Changle
 * Date: 2018-03-11 12:01
 * Source: https://leetcode.com/problems/valid-anagram/description/
 */

/**
 * 先将 s 中的元素放入 map 中。然后遍历 t 元素。
 * 最后检查 map 中的 value 。如果有一个不为 0 。说明有不同的字符存在。
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
public class Solution {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int j = 0; j < t.length(); j++) {
            char ch = t.charAt(j);
            if (map.containsKey(ch) && map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
            } else {
                return false;
            }
        }

        for (int i : map.values()) {
            if (i != 0) {
                return false;
            }
        }

        return true;

    }
}
