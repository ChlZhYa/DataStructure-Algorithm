import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author changleamazing
 * @date 2020/9/11 17:06 source: https://leetcode-cn.com/problems/combination-sum-ii/
 **/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return null;
        }
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> tempList = new LinkedList<>();
        backtrace(candidates, 0, target, tempList, res);
        return res;
    }

    private void backtrace(int[] candidates, int begin, int target, Deque<Integer> tempQueue, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(tempQueue));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target < candidates[i]) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            tempQueue.add(candidates[i]);
            backtrace(candidates, i + 1, target - candidates[i], tempQueue, res);
            tempQueue.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {4, 4, 2, 1, 4, 2, 2, 1, 3};
        Solution solution = new Solution();
        solution.combinationSum2(candidates, 6);
    }
}
