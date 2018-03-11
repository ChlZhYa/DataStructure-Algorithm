import java.util.HashSet;
import java.util.Set;

/**
 * User: Changle
 * Date: 2018-03-11 10:41
 * Source: https://leetcode.com/problems/happy-number/description/
 */

/*
通过模运算与除法得出一个数的每一位，然后求他们的平方的和。
用集合存储每一次的值，当出现一样的值时，说明出现循环，返回 false。

时间复杂度: O(?)
空间复杂度: O(?)
 */
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        int squareSum,remain;
        while(set.add(n)){
            squareSum = 0;
            while(n > 0){
                remain = n % 10;
                squareSum += remain * remain;
                n = n / 10;
            }

            if(squareSum == 1)
                return true;
            else
                n = squareSum;

        }
        return false;
    }
}
