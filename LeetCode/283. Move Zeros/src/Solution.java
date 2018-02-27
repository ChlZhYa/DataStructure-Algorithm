/**
 * User: Changle
 * Date: 2018-02-07 15:21
 * Source: https://leetcode.com/problems/move-zeroes/description/
 */

/*
双指针，一个指针 i 扫描数组，将不为 0 的数放置在位置 j 上，j 向后移动一位。。
i 扫描结束后，j 的位置到数组最后的位置全部用 0 填充。

时间复杂度O(n)
空间复杂度O(1)
 */
class Solution1 {

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

/*
同样是建立两个指针，但是遇到不为 0 的数时，直接与 j 指针交换。
j 始终指向第一个为 0 的元素。节约了置 0 的时间。

时间复杂度O(n)
空间复杂度O(1)
 */
class Solution2 {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                exch(nums, i, j);
                j++;
            }
        }
    }

    private void exch(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}