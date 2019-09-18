import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author Changle
 * @date 2019/9/18 17:05
 * resource: https://leetcode.com/problems/counting-bits/
 */

public class Solution1 {

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = getCountOfOneAppearInBitsOfNumer(i);
        }
        return res;
    }

    private int getCountOfOneAppearInBitsOfNumer(int num) {
        int count = 0;
        int curBit;
        while (num > 0) {
            curBit = num % 2;
            if (curBit == 1) {
                count++;
            }
            num = num / 2;
        }
        return count;
    }
}
