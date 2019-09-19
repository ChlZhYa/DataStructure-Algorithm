import java.util.HashMap;
import java.util.Map;

/**
 * @author: changle
 * @time: 2019-06-13 02:33
 * source: https://leetcode.com/problems/roman-to-integer/
 */
public class Solution {

    Map<String, Integer> map = new HashMap<>();

    //map 初始化
    public void initMap() {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
    }

    public int romanToInt(String s) {
        initMap();

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            //判断是否是两位字符表示的数字
            if (s.length() - i > 1 && map.get(s.substring(i, i + 2)) != null) {
                result += map.get(s.substring(i, i + 2));
                i++;
            } else {
                result += map.get("" + s.charAt(i));
            }
        }

        return result;
    }
}
