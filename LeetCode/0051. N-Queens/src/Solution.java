import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author changleamazing
 * @date 2019/12/17 01:27
 * source: https://leetcode.com/problems/n-queens/
 **/
public class Solution {

    int max;

    int[] position;

    public List<List<String>> solveNQueens(int n) {
        position = new int[n];
        max = n;
        List<List<String>> res = new ArrayList<>();
        // 存储结果中一种情形的列表
        List<String> situation = new ArrayList<>();
        place(0, situation, res);
        return res;
    }

    private void place(int rowN, List<String> situation, List<List<String>> res) {
        if (rowN == max) {
            // 说明找到一种解，加入 res
            res.add(new ArrayList<>(situation));
            // 移除最后一个元素，继续向下遍历
            situation.remove(rowN - 1);
            return;
        }
        for (int column = 0; column < max; column++) {
            // 将第 row 行的皇后放置于  position[row] 处
            position[rowN] = column;
            // 校验该位置是否可以放置
            if (judge(rowN)) {
                //    可以放置则存放该行的情况
                char[] chars = new char[max];
                Arrays.fill(chars, '.');
                chars[position[rowN]] = 'Q';
                situation.add(new String(chars));
                //    继续放下一行的皇后
                place(rowN + 1, situation, res);
            }
        }

        // 如果已经遍历完该行，仍然没有找到位置，说明上一行的皇后需要继续向右移，删除上一行中已经放入 situation 的字符串
        if (rowN != 0) {
            situation.remove(rowN - 1);
        }
    }

    private boolean judge(int rowN) {
        // 遍历已经摆放过皇后的行
        for (int row = 0; row < rowN; row++) {
            // 如果 (row,position[row]) 于 (rowN,position[rowN]) 位于一列或者两点斜率为 1，则不能放置
            if (position[row] == position[rowN] || rowN - row == Math
                    .abs(position[rowN] - position[row])) {
                return false;
            }
        }
        return true;
    }

}
