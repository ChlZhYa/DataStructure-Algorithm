import java.util.HashMap;

/**
 * User: Changle
 * Date: 2018-03-11 13:27
 * Source: https://leetcode.com/problems/4sum-ii/description/
 */

/**
 * 将 C + D 的和放入到 map 中。确定 A 中的数，然后遍历 B 集合，
 *
 * 时间复杂度: O(n^3)
 * 空间复杂度: O(n)
 */
public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int element : C) {
            for (int value : D) {
                if (map.containsKey(element + value)) {
                    map.put(element + value, map.get(element + value) + 1);
                } else {
                    map.put(element + value, 1);
                }
            }
        }

        int res = 0;
        for (int item : A) {
            for (int value : B) {
                if (map.containsKey(-item - value)) {
                    res = res + map.get(-item - value);
                }
            }
        }

        return res;
    }

}

