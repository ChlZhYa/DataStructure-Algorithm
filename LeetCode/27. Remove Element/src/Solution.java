/**
 * @author Changle
 * @date 2019/7/3 9:35
 * resource: https://leetcode.com/problems/remove-element/
 * T(n)：O(n)
 * S(n)：O(1)
 * Tag ：Double Pointer Swap
 */

public class Solution {

    public int removeElement(int[] nums, int val) {

        if (nums == null) {
            return 0;
        }
        // 待判断的数
        int left = 0;
        // 数组尾部确定等于 val 的数的前一位（即最后一位不确定值的数）
        int right = nums.length - 1;

        // 当 left == right 时，left 为待判断位，right 也为不确定，需要继续判断，所以
        // while 循环条件中需要包括 left == right
        while (left <= right) {
            // nums[left] == val 时，交换 left 和 right 对应的值
            // 此时 nums[right] 确定等于 val，right左移。但是 nums[left] 不确定，所以 left 不移动。
            if (nums[left] == val) {
                swap(left, right, nums);
                right--;
            }
            // 此时 nums[left] 确定不等于 val，left右移，right 不移动。
            else {
                left++;
            }

        }
        return right + 1;
    }

    private void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
