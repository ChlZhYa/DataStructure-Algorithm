import java.util.Arrays;

/**
 * User: Changle
 * Date: 2018-03-11 10:16
 * Source: https://leetcode.com/problems/3sum-closest/description/
 */

/*
使用绝对值来判断距离。先排序，固定一个数，然后使用对撞指针。

时间复杂度: O(n^2)
空间复杂度: O(1)
 */
public class Solution {
    // 因为必定存在结果，所以直接先把结果设置成数组里面三个数字的和
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                res = Math.abs(sum - target) < Math.abs(res - target) ? sum : res;
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    return sum;
                }
            }
        }
        return res;
    }
}
