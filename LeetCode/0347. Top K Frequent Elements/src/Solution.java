import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author changleamazing
 * @date 2019/11/23 12:09
 * source: https://leetcode.com/problems/top-k-frequent-elements/
 **/
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {


        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.get(num) == null ? 1 : map.get(num) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));


        for(int key:map.keySet()){
            if(queue.size() < k){
                queue.add(key);
            }else if(map.get(key) > map.get(queue.peek())){
                queue.remove();
                queue.add(key);
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!queue.isEmpty()){
            res.add(queue.remove());
        }
        return res;
    }

}
