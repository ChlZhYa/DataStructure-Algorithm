/**
 * User: Changle
 * Date: 2018-02-08 09:19
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */

/*
不允许使用额外的空间复杂度，所以应该是在数组内交换位置，采用双指针。
 i 指向第一个确定值的元素。
 j 指针扫描数组，当遇到与前一个数不同时，就把这个新的数放到 ++i 位置上。

时间复杂度O(n)
空间复杂度O(1)
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 1;j < nums.length;j++){
            if(nums[j] != nums[j - 1])
                nums[++i] = nums[j];
        }
        return i + 1;
    }
}
