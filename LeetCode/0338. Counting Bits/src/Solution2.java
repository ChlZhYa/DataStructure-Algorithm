/**
 * @author Changle
 * @date 2019-9-18 17:34:56
 * resource: https://leetcode.com/problems/counting-bits/
 */

public class Solution2 {

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                res[i] = res[i >> 1];
            } else {
                res[i] = res[i - 1] - 1;
            }
        }
        return res;
    }
}
