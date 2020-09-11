import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author changleamazing
 * @date 2020/9/11 16:36 source: https://leetcode-cn.com/problems/combination-sum/
 **/
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0){
            return null;
        }
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> tempList = new LinkedList<>();
        backtrace(candidates,0,target,tempList,res);
        return res;
    }

    private void backtrace(int[] candidates,int begin,int target,Deque<Integer> tempQueue,List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(tempQueue));
            return;
        }
        for(int i = begin;i < candidates.length ;i++){
            if(target < candidates[i]){
                break;
            }
            tempQueue.add(candidates[i]);
            backtrace(candidates, i, target - candidates[i], tempQueue, res);
            tempQueue.removeLast();
        }
    }
}
