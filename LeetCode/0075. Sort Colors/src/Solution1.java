/**
 * @author changleamazing
 * @date 2019/11/23 12:27
 **/
/*
整个数组中只有3种取值，可以直接统计每种取值的数量，再按顺序赋值。计数排序的思想。

时间复杂度：O(n)
空间复杂度：O(1)
 */
class Solution1 {

    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            } else if (nums[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < count0) {
                nums[i] = 0;
            }
            if (i >= count0 && i < nums.length - count2) {
                nums[i] = 1;
            }
            if (i >= nums.length - count2) {
                nums[i] = 2;
            }
        }
    }
}
