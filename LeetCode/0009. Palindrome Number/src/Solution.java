/**
 * @author: changle
 * @time: 2019-06-11 21:32
 * source: https://leetcode.com/problems/palindrome-number/
 */
public class Solution {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        long reverse = 0;
        int primaryX = x;
        int curBit;
        for (int i = getLengthOfInteger(x) - 1; i >= 0; i--) {

            curBit = x % 10;
            x /= 10;
            reverse += curBit * Math.pow(10, i);
        }

        return  reverse == primaryX ;
    }


   static int getLengthOfInteger(int x) {
        // x 的长度
        int lengthOfX = 0;
        int temp = x;
        while (temp > 0) {
            temp /= 10;
            lengthOfX++;
        }
        return lengthOfX;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));

    }


}
