/**
 * User: Changle
 * Date: 2018-02-07 21:09
 * Source: https://leetcode.com/problems/remove-element/description/
 */

/*
本题不需要管 返回的length 之后的元素。
所以使用双指针交换。保持 i 指针位于第一个等于 val 的元素。
用 j 遍历数组，当遇到等于 不等于 val 的元素时，与 i 位置上的元素交换位置。

时间复杂度O(n)
空间复杂度O(1)
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0;j < nums.length;j++){
            if(nums[j] != val){
                if(i != j)
                    exch(nums,i,j);
                i++;
            }
        }
        return i;
    }

    private void exch(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
