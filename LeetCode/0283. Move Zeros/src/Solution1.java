/**
 * @author changleamazing
 * @date 2019/11/23 13:52
 **/

/**
 * 同样是建立两个指针，但是遇到不为 0 的数时，直接与 j 指针交换。
 * j 始终指向第一个为 0 的元素。节约了置 0 的时间。
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
class Solution1 {

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
