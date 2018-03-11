import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Changle
 * Date: 2018-03-11 10:13
 * Source: https://leetcode.com/problems/3sum/description/
 */

/*
考虑到 3sum 至少需要两遍循环，复杂度至少是 O(n^2) ，所以可以先排序。
排序之后使用对撞指针即可。

时间复杂度: O(n^2)
空间复杂度: O(n)
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < 0) {
                    while (left < right && nums[left] == nums[left+1]) left ++;
                    left++;
                }
                else if (nums[i] + nums[left] + nums[right] > 0) {
                    while (left < right && nums[right] == nums[right - 1]) right --;
                    right --;
                } else {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left ++;
                    left++;
                    while (left < right && nums[right] == nums[right - 1])right--;
                    right--;
                }
            }
        }
        return res;
    }
}
