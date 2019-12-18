/**
 * @author changleamazing
 * @date 2019/12/18 23:21
 * source: https://leetcode.com/problems/maximum-subarray/
 **/
public class Solution {

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = nums[0];

        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }

            res = Math.max(res, sum);
        }
        return res;
    }
}
