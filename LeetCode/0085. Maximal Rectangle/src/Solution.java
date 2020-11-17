/**
 * User: Changle
 * Date: 2020-11-17 16:24
 * Source: https://leetcode-cn.com/problems/maximal-rectangle/
 */

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int maxArea = 0;

        int rows = matrix.length, columns = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (matrix[row][column] == '1') {
                    maxArea = Math.max(maxArea, findNewArea(row, column, matrix));
                }
            }
        }
        return maxArea;
    }

    private int findNewArea(int row, int column, char[][] matrix) {
        int area = 0, width = column;
        for (int r = row; r >= 0; r--) {
            if (matrix[r][column] == '0') {
                return area;
            }
            int maxCols = 0;
            for (int c = column; c >= column - width; c--) {
                if (matrix[r][c] == '0') {
                    break;
                }else{
                    maxCols++;
                }
            }
            width = Math.min(width, maxCols - 1);
            area = Math.max(area, (width + 1) * (row - r + 1));
        }
        return area;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maximalRectangle(new char[][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
    }
}
