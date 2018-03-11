import java.util.HashMap;
import java.util.Map;

/**
 * User: Changle
 * Date: 2018-03-11 10:46
 * Source: https://leetcode.com/problems/isomorphic-strings/description/
 */

/*
判断是不是同样结构的字符串。通过映射来判断。
关于 put 方法：如果 map 中之前存在该 key，就会返回之前的 value。
这样可以一直保证两个字符串的映射一一匹配。

时间复杂度: O(n)
空间复杂度: O(n)
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map index = new HashMap();
        for (int i=0; i<s.length(); ++i)
            if (index.put(s.charAt(i), i) != index.put(t.charAt(i), i))
                return false;
        return true;
    }
}