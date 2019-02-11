import java.util.ArrayList;
import java.util.List;

/**
 * @author: changle
 * @time: 2019-02-11 10:37:04
 * Source: https://leetcode.com/problems/permutations/
 */

class Solution {
    
    private List<List<Integer>> res = new ArrayList<>(); 
    private boolean[] used;
    
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        for(int i = 0;i < nums.length;i++){
            used[i] = false;
        }
        partition(nums,new ArrayList<Integer>()); 
        return res;
    }
    
    private void partition(int[] nums,List<Integer> numList){
        if(numList.size() == nums.length)
            res.add(new ArrayList(numList));
        for(int i = 0;i < nums.length;i++){
          if(!used[i]){
              numList.add(nums[i]);
              used[i] = true;                        
              partition(nums,numList);
              numList.remove(numList.size() - 1);
              
              used[i] = false;
          }
        }
    }
}
