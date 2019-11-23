/**
 * User: Changle
 * Date: 2018-02-08 15:40
 * Source: https://leetcode.com/problems/sort-colors/description/
 */

/**
 * 三路快排
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class Solution {

    public void sortColors(int[] nums) {
        int i = 0, l = 0, r = nums.length - 1;
        while (i <= r) {
            if (nums[i] < 1) {
                exch(nums, i, l);
                i++;
                l++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                exch(nums, i, r);
                r--;
            }
        }
    }

    private void exch(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}


