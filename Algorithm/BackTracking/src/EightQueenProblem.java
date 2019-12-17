/**
 * @author changleamazing
 * @date 2019/12/17 00:51
 **/
public class EightQueenProblem {

    int max = 8;

    /**
     * 表示第 i 行的皇后位于第 arr[i] 列
     */
    int[] arr = new int[max];

    /**
     * @param n 表示第 n 行的数据
     */
    private void check(int n) {
        if (n == max) {
            return;
        }
        // 遍历第 n 行所有的列
        for (int column = 0; column < max; column++) {
            //    先将第 n 行的皇后放在 column 列
            arr[n] = column;
            //    判断该位置是否允许放置
            if (judge(n)) {
                //    如果第 n 行元素允许被放置，则继续放置下一行元素
                check(n + 1);
            }
        }
    }

    /**
     * 此时第 n 行的皇后已经被放置在了 arr[n] 处。
     * 判断(n,arr[n]) 是否允许被放置元素
     */
    private boolean judge(int n) {
        // 遍历行
        for (int row = 0; row < n; row++) {
            // 第 row 行皇后坐标为 (row,arr[row])。
            // 如果 (row,arr[row]) 和 (n,arr[n]) 同一列或者两点斜率为 1，则该坐标不能使用
            if (arr[row] == arr[n] || n - row == Math.abs(arr[n] - arr[row])) {
                return false;
            }
        }
        return true;
    }

}
