/**
 * User: Changle
 * Date: 2017-12-27 11:08
 * Description:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 时间限制：1秒 空间限制：32768K
 */

public class Solution {

    public int JumpFloorII(int target) {
        if (target <= 2) {
            return target;
        }
        int[] arr = new int[target];
        arr[0] = 1; arr[1] = 2;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                arr[i] += arr[j];
            }
        }
        return arr[target -1];
    }
}