import java.util.HashSet;
import java.util.Set;

/**
 * User: Changle
 * Date: 2018-03-11 13:07
 * Source: https://leetcode.com/problems/intersection-of-two-arrays/description/
 */

/*
将一个数组中的元素加入到集合中，然后遍历另一个元素。判断元素是否在集合中出现。

时间复杂度: O(n)
空间复杂度: O(n)
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> resSet  = new HashSet<>();

        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < nums1.length;i++){
            set.add(nums1[i]);
        }

        for(int j = 0;j < nums2.length;j++){
            if(set.contains(nums2[j]))
                resSet.add(nums2[j]);
        }

        int[] res = new int[resSet.size()];
        int index = 0;

        for(Integer i : resSet)
            res[index++] =  i;

        return res;
    }
}