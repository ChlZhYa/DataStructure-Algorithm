/**
 * @author changleamazing
 * @date 2019/12/14 12:47
 * source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 **/
public class Solution {

    public int maxProfitWithInf(int[] prices) {
        int dayiWithoutHold = 0;
        int dayiWithHold = Integer.MIN_VALUE;

        for (int price : prices) {
            int temp = dayiWithoutHold;
            dayiWithoutHold = Math.max(temp, dayiWithHold + price);
            dayiWithHold = Math.max(dayiWithHold, temp - price);
        }
        return dayiWithoutHold;
    }
}