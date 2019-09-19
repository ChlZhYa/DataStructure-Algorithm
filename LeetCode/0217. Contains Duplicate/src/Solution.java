import java.util.HashSet;

/**
 * User: Changle
 * Date: 2018-03-11 10:51
 * Source: https://leetcode.com/problems/contains-duplicate/description/
 */

/*
遍历数组，将元素加入到集合中。有重复则返回 true。

时间复杂度: O(n)
空间复杂度: O(n)
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (int val : nums) {
            if (!hashSet.add(val)) {
                return true;
            }
        }
        return false;
    }
}
