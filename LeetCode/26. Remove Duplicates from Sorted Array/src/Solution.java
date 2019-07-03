/**
 * @author Changle
 * @date 2019/6/27 9:46
 * source: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * T(n) : O(n)
 * S(n) : O(1)
 * Tag  : Double Pointer
 */

public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] > nums[left]) {
                nums[++left] = nums[right++];
            } else {
                right++;
            }
        }
        return left + 1;
    }
}
