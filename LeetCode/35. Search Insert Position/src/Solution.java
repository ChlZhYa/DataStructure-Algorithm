/**
 * @author: changle
 * @time: 2019-01-14 03:03
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, 0, nums.length - 1, target);
    }

    private int searchInsert(int[] nums, int lo, int hi, int target) {
        if (lo > hi) {
            return lo;
        }
        int mid = lo + (hi - lo) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            return searchInsert(nums, 0, mid - 1, target);
        } else {
            return searchInsert(nums, mid + 1, hi, target);
        }
    }
}
