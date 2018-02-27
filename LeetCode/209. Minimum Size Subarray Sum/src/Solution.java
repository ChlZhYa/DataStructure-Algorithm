/**
 * User: Changle
 * Date: 2018-02-21 09:00
 * Source: https://leetcode.com/problems/minimum-size-subarray-sum/description/
 */

/*
使用滑动窗口，不断改变窗口的范围，来计算范围内的值。

时间复杂度: O(n)
空间复杂度: O(1)
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0;int j = -1;
        int sum = 0;
        int res = nums.length + 1;
        while(i < nums.length){
            if(j + 1 < nums.length && sum < s){
                sum = sum + nums[++j];
            }else{
                sum = sum - nums[i++];
            }

            if (sum >= s) {
                res = Math.max(res, j - i + 1);
            }
        }
        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }
}