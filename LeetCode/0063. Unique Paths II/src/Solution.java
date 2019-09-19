/**
 * @author Changle
 * @date 2018/10/26 19:54
 */

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int n = obstacleGrid.length;
        if(obstacleGrid.length == 0){
            return 1;
        }

        int m = obstacleGrid[0].length;

        int[][] res = new int[n][m];

        for(int i = n - 1;i >= 0;i--){
            for(int j = m - 1;j >= 0;j--){
                if( i == n - 1 && j == m - 1){
                    res[i][j] = (obstacleGrid[i][j] == 0) ? 1 : 0 ;
                    continue;
                }
                if( obstacleGrid[i][j] == 1){
                    res[i][j] = 0;
                    continue;
                }
                if(i == n - 1){
                    res[i][j] = res[i][j + 1];
                    continue;
                }
                if(j == m - 1){
                    res[i][j] = res[i + 1][j];
                    continue;
                }
                res[i][j] = res[i + 1][j] + res[i][j + 1];
            }
        }

        return res[0][0];
    }
}
