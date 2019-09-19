import java.util.HashMap;
import java.util.Map;

/**
 * User: Changle
 * Date: 2018-03-11 10:05
 * Source: https://leetcode.com/problems/two-sum/description/
 */

/*
因为无序所以不能使用对撞指针，而且需要记录索引值，因此将数据存储在 HashMap 中。
所以先将元素遍历一遍加入到 hashmap 中。第二次遍历时，去 hashmap 中查找 target - nums[i]。

时间复杂度: O(n)
空间复杂度: O(n)
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        Map<Integer,Integer> map = new HashMap();
        for(int i = 0;i < nums.length;i++){
            map.put(nums[i],i);
        }

        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(target - nums[i])){
                if(map.get(target - nums[i]) != i){

                    res[0] = i;
                    res[1] = map.get(target - nums[i]);
                    break;
                }
            }
        }

        return res;

    }
}
