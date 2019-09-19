/**
 * @author Changle
 * @date 2018/10/23 19:30
 */

public class Solution {

    public int minPathSum(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        for (int i = 1; i < m; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        for (int j = 1; j < n; j++) {
            grid[j][0] = grid[j - 1][0] + grid[j][0];
        }

        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                grid[y][x] = grid[y][x] + Math.min(grid[y - 1][x], grid[y][x - 1]);
            }
        }

        return grid[n - 1][m - 1];
    }
}
