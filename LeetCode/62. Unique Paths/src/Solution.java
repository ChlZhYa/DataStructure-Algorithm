/**
 * @author Changle
 * @date 2018/10/25 18:20
 */

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[n][m];
        res[n - 1][m - 1] = 0;
        for(int i = m - 1;i >= 0;i--){
            for(int j = n - 1;j >= 0;j--){
                if(i == m - 1){
                    res[j][i] = 1;
                    continue;
                }
                if(j == n - 1){
                    res[j][i] = 1;
                    continue;
                }
                res[j][i] = res[j + 1][i]+res[j][i+1];
            }
        }
        return res[0][0];
    }
}
