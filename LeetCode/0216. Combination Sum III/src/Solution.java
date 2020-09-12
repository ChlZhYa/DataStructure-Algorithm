import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author changleamazing
 * @date 2020/9/12 21:13
 **/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        backtrace(1, k, n, queue, res);
        return res;
    }

    private void backtrace(int number, int restCount, int restSum, Deque<Integer> queue, List<List<Integer>> res) {
        if (restCount == 0) {
            if (restSum == 0) {
                res.add(new ArrayList<>(queue));
            }
            return;
        }
        for (int i = number; i <= restSum && i <= 9; i++) {
            queue.add(i);
            backtrace(i + 1, restCount - 1, restSum - i, queue, res);
            queue.removeLast();
        }
    }
}