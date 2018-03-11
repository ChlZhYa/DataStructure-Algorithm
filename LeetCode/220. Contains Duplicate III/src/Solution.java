import java.util.TreeSet;

/**
 * User: Changle
 * Date: 2018-03-11 11:26
 * Source: https://leetcode.com/problems/contains-duplicate-iii/description/
 */

/*
找范围内的数，可以通过 treeset 的有序性。使用 ceilling 函数来判断是否存在范围内的值

时间复杂度: O(nlogn)
空间复杂度: O(n)
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.ceiling((long)nums[i] - t) !=null && set.ceiling((long)nums[i] - t) <= (long)nums[i] + t) {
                return true;
            }

            set.add((long)nums[i]);

            if (set.size() == k + 1) {
                set.remove((long)nums[i - k]);
            }
        }

        return false;

    }
}