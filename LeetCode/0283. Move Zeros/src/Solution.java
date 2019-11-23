/**
 * User: Changle
 * Date: 2018-02-07 15:21
 * Source: https://leetcode.com/problems/move-zeroes/description/
 */

/**
 * 双指针，一个指针 i 扫描数组，将不为 0 的数放置在位置 j 上，j 向后移动一位。。
 * i 扫描结束后，j 的位置到数组最后的位置全部用 0 填充。
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for (int k = j; k < nums.length; k++) {
            nums[k] = 0;
        }

    }
}

