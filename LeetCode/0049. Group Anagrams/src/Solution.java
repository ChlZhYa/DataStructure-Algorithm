import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Changle
 * Date: 2018-03-11 10:30
 * Source: https://leetcode.com/problems/group-anagrams/description/
 */

/**
 * 需要将同字符异序串组合，最直接的方式是将字符串排序。
 * 对于每个字符，将它们排序，如果排序后的结果一致，那么加入同一个 List。
 * 用 Map 来存储所有的 List。
 *
 * 时间复杂度: O(n^2 * logn)
 * 空间复杂度: O(n)
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] carr = str.toCharArray();
            Arrays.sort(carr);
            String s = String.valueOf(carr);
            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                map.put(s, new ArrayList<>());
                map.get(s).add(str);
            }
        }

        return new ArrayList<>(map.values());
    }
}
