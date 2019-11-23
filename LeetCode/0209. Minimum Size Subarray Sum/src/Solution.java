/**
 * User: Changle
 * Date: 2018-02-21 09:00
 * Source: https://leetcode.com/problems/minimum-size-subarray-sum/description/
 */

/**
 * 使用滑动窗口，不断改变窗口的范围，来计算范围内的值。
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
public class Solution {


    public int minSubArrayLen(int s, int[] nums) {
         int res = Integer.MAX_VALUE;
        if (nums == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (left <= right && sum >= s) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        if (res == Integer.MAX_VALUE) {
            return 0;
        }
        return res;
    }
}
