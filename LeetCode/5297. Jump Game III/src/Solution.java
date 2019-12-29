import java.util.HashSet;

/**
 * @author changleamazing
 * @date 2019/12/29 11:01
 * source: https://leetcode-cn.com/contest/weekly-contest-169/problems/jump-game-iii/
 **/
public class Solution {

    private HashSet<Integer> targetSet = new HashSet<>();

    public boolean canReach(int[] arr, int start) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                targetSet.add(i);
            }
        }
        if (targetSet.size() == 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (dfs(arr, start, targetSet, new HashSet<>())) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int[] arr, int index, HashSet<Integer> targetSet, HashSet<Integer> set) {
        if (set.contains(index)) {
            return false;
        }
        if (targetSet.contains(index + arr[index]) || targetSet.contains(index - arr[index])) {
            return true;
        }
        boolean res = false;
        if (index + arr[index] < arr.length) {
            set.add(index);
            res = dfs(arr, index + arr[index], targetSet, set);
        }
        if (index - arr[index] >= 0) {
            set.add(index);
            res = dfs(arr, index - arr[index], targetSet, set) | res;
        }
        return res;
    }


}
