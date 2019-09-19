import java.util.HashMap;

/**
 * User: Changle
 * Date: 2018-03-11 13:27
 * Source: https://leetcode.com/problems/4sum-ii/description/
 */

/*
将 C + D 的和放入到 map 中。确定 A 中的数，然后遍历 B 集合，

时间复杂度: O(n^3)
空间复杂度: O(n)
 */
public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if (map.containsKey(C[i] + D[j])) {
                    map.put(C[i] + D[j], map.get(C[i] + D[j]) + 1);
                } else {
                    map.put(C[i] + D[j], 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (map.containsKey(-A[i] - B[j])) {
                    res = res + map.get(-A[i] - B[j]);
                }
            }
        }

        return res;
    }

}

