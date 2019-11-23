import java.util.HashMap;
import java.util.Map;

/**
 * User: Changle
 * Date: 2018-03-11 10:36
 * Source: https://leetcode.com/problems/max-points-on-a-line/description/
 */

/**
 * 同一条线上的任意两点的斜率相同。
 * 将斜率相同的两个点放在一起
 *
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 */
public class Solution {

    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }

        int result = 0;
        // 遍历每个点
        for (int i = 0; i < points.length; i++) {
            int duplicate = 0;
            int max = 0;
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == 0) {
                    duplicate++;
                    continue;
                }
                //进行约分
                int gcd = gcd(x, y);
                x = x / gcd;
                y = y / gcd;
                String key = x + "@" + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            //1 代表当前考虑的点，duplicate 代表和当前的点重复的点
            result = Math.max(result, max + duplicate + 1);
        }
        return result;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}

