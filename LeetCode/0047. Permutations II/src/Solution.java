import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author changleamazing
 * @date 2020/9/18 14:18
 * source: https://leetcode-cn.com/problems/permutations-ii/solution/quan-pai-lie-ii-by-leetcode-solution/
 **/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        int[] flag = new int[nums.length];
        backtrace(nums, 0, queue, flag, res);
        return res;
    }

    private void backtrace(int[] nums, int index, Deque<Integer> queue, int[] flag, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(queue));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 剪枝
            if (flag[i] == 1 || (i < nums.length - 1 && nums[i + 1] == nums[i] && flag[i + 1] == 0)) {
                continue;
            }
            if (flag[i] == 0) {
                flag[i] = 1;
                queue.add(nums[i]);
                backtrace(nums, index + 1, queue, flag, res);
                queue.removeLast();
                flag[i] = 0;
            }
        }
    }
}