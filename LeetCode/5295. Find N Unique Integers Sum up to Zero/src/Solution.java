/**
 * @author changleamazing
 * @date 2019/12/29 10:40
 * source: https://leetcode-cn.com/contest/weekly-contest-169/problems/find-n-unique-integers-sum-up-to-zero/
 **/
public class Solution {

    public int[] sumZero(int n) {
        int[] res = new int[n];
        if (n % 2 == 0) {
            for (int i = 0, start = -n / 2; i < n; i++) {
                res[i] = start++;
                if (res[i] >= 0) {
                    res[i]++;
                }
            }
        } else {
            for (int j = 0, begin = -(n - 1) / 2; j < n; j++) {
                res[j] = begin++;
            }
        }
        return res;
    }

}