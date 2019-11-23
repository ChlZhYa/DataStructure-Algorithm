import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Changle
 * Date: 2018-03-11 13:10
 * Source: https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 */

/**
 * 将一个数组遍历一遍，放入 map 中。然后遍历第二个数组。
 * 如果元素对应的 value > 0，说明这个数是共同元素。
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.merge(i, 1, Integer::sum);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.get(nums2[i]) != null && map.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int[] res = new int[list.size()];
        int index = 0;
        for (Integer i : list) {
            res[index++] = i;
        }
        return res;
    }
}
