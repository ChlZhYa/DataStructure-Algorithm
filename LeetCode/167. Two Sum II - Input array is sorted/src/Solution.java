/**
 * User: Changle
 * Date: 2018-02-13 23:55
 * Source: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */

/*
由于数组有序，使用对撞指针。
当两个指针处的数字之和大于 target ，则 j 向左移动。
反之 i 向右移动。

时间复杂度：O(n)
空间复杂度: O(1)
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0,j = numbers.length - 1;
        int[] res = new int[2];
        while(i < j){
            if(numbers[i] + numbers[j] == target){
                res[0] = i + 1;
                res[1] = j + 1;
                break;
            }else if(numbers[i] + numbers[j] < target)
                i++;
            else
                j--;

        }
        return res;
    }
}