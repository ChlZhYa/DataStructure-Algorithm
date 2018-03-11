import java.util.HashMap;
import java.util.Map;

/**
 * User: Changle
 * Date: 2018-03-11 12:42
 * Source: https://leetcode.com/problems/word-pattern/description/
 */

/*
把字符与字符串对应放入 map 中。

时间复杂度: O(n)
空间复杂度: O(n)
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(pattern.length() != words.length)
            return false;

        Map<Character,String> map = new HashMap<>();

        for(int i = 0;i < pattern.length();i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(words[i]))
                    return false;
            }else{
                if(map.containsValue(words[i]))
                    return false;
                map.put(c,words[i]);
            }
        }
        return true;
    }
}