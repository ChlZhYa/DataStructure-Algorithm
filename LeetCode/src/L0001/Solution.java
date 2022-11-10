package L0001;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            if (hashMap.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = hashMap.get(target - nums[i]);
                return res;
            }else{
                hashMap.put(nums[i], i);
            }
        }
        return res;
    }
}