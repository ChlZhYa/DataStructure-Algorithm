/**
 * @author changleamazing
 * @date 2020/1/5 11:12
 * source: https://leetcode-cn.com/contest/weekly-contest-170/problems/xor-queries-of-a-subarray/
 **/
public class Solution {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if(l < 0 || r > arr.length){
                result[i] = 0;
                continue;
            }
            int res = arr[l];
            for (int j = l+1; j <= r; j++) {
                res = res ^ arr[j ];
            }
            result[i] = res;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] queries = new Solution()
                .xorQueries(new int[]{1,3,4,8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}});
        for (int i = 0; i < queries.length; i++) {
            System.out.println(queries[i]);
        }

    }
}