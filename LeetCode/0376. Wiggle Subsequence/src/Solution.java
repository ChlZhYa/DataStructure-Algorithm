import java.util.Arrays;

/**
 * @author: changle
 * @time: 2019/9/28 03:26
 * source: https://leetcode.com/problems/wiggle-subsequence/
 */
public class Solution {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = 1;
        int[] flag = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] && flag[i - 1] != 1) {
                flag[i] = 1;
                result++;
            } else if (nums[i] < nums[i - 1] && flag[i - 1] != -1) {
                flag[i] = -1;
                result++;
            } else {
                flag[i] = flag[i - 1];
            }
        }
        return result;
    }

}
