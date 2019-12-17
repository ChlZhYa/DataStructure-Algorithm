/**
 * @author changleamazing
 * @date 2019/12/18 03:05
 * source: https://leetcode.com/problems/n-queens-ii/
 **/
public class Solution {

    int res;

    public int totalNQueens(int n) {
        int[] position = new int[n];
        place(0, position);
        return res;
    }

    private void place(int rowN, int[] position) {
        if (rowN == position.length) {
            res++;
            return;
        }
        for (int column = 0; column < position.length; column++) {
            position[rowN] = column;
            if (judge(rowN, position)) {
                place(rowN + 1, position);
            }
        }
    }

    private boolean judge(int rowN, int[] position) {
        for (int row = 0; row < rowN; row++) {
            if (position[row] == position[rowN] || rowN - row == Math
                    .abs(position[rowN] - position[row])) {
                return false;
            }
        }
        return true;
    }

}