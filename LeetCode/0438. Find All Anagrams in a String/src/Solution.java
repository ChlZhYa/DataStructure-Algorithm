import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * User: Changle
 * Date: 2018-02-21 18:16
 * Source: https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */

/*
使用滑动窗口。
count 记录还有几个 p 中的字符应该出现。

时间复杂度: O(len(p) + len(s))
空间复杂度: O(len(p))
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] ch = new int[256];
        for(char c:p.toCharArray()){
            ch[c]++;
        }

        int i = 0,j = 0;
        int count = p.length();
        while(i < s.length() && j < s.length()){
            if(ch[s.charAt(j++)]-- > 0)
                count--;

            if(count == 0)
                list.add(i);

            if(j - i == p.length() && ch[s.charAt(i++)]++ >= 0)
                count++;
        }

        return list;

    }
}
