/**
 * @author changleamazing
 * @date 2019/11/23 14:09
 * source: https://leetcode.com/problems/unique-binary-search-trees/
 **/
public class Solution {
    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                nums[i] += nums[j] * nums[i - j - 1];
            }
        }
        return nums[n];
    }
}
