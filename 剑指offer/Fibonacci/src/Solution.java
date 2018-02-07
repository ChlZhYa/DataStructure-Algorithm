/**
 * User: Changle
 * Date: 2017-12-27 10:45
 * Description:
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 * 时间限制：1秒 空间限制：32768K
 */

public class Solution {

    public int Fibonacci(int n) {
        int[] arr = new int[40];
        arr[0] = 0;
        arr[1] = 1;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int index = 2;
        while (true) {
            arr[index] = arr[index - 1] + arr[index - 2];
            if (index == n) {
                return arr[index];
            }
            index++;
        }
    }
}
