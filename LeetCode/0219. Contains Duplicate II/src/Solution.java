import java.util.HashSet;
import java.util.Set;

/**
 * User: Changle
 * Date: 2018-03-11 10:54
 * Source: https://leetcode.com/problems/contains-duplicate-ii/description/
 */

/**
 * 遍历数组，将元素放入集合中，保持集合中的元素个数不超过 k + 1个。
 * 判断最新加入来的元素是否在 set 中出现过。
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }

            if (set.size() == k + 1) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
