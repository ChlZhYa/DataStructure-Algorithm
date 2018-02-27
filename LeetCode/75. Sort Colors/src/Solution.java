/**
 * User: Changle
 * Date: 2018-02-08 15:40
 * Source: https://leetcode.com/problems/sort-colors/description/
 */

/*
三路快排

时间复杂度O(n)
空间复杂度O(1)
 */
public class Solution {
    public void sortColors(int[] nums) {
        int i=0,l = 0,r = nums.length - 1;
        while(i <= r){
            if(nums[i] < 1){
                exch(nums,i,l);
                i++;
                l++;
            }else if(nums[i] == 1)
                i++;
            else {
                exch(nums,i,r);
                r--;
            }
        }
    }

    private void exch(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}

/*
整个数组中只有3种取值，可以直接统计每种取值的数量，再按顺序赋值。计数排序的思想。

时间复杂度：O(n)
空间复杂度：O(1)
 */
class Solution1 {
    public void sortColors(int[] nums) {
        int count0 = 0,count1 = 0,count2 = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 0){
                count0++;
            }else if(nums[i] == 1){
                count1++;
            }else
                count2++;
        }

        for(int i = 0;i < nums.length;i++){
            if(i < count0)
                nums[i] = 0;
            if(i >= count0 && i < nums.length - count2){
                nums[i] = 1;
            }
            if(i >= nums.length - count2){
                nums[i] = 2;
            }
        }
    }
}