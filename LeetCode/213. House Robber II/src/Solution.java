import java.util.Arrays;

/**
 * @author Changle
 * @date 2018/10/30 15:13
 */

public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }
        int[] memo = new int[n];
        // 在抢劫 nums[n - 1] 的情况下
        memo[0] = nums[0];
        for(int i = 1;i < n - 1;i++){
            memo[i] = Math.max(memo[i - 1],nums[i] + (i >= 2 ? memo[i - 2] : 0));
        }
        int max1 = memo[n - 2];

        // 清空数组
        Arrays.fill(memo,0);
        // 在不抢劫 nums[0] 的情况下
        memo[n - 1] = nums[n - 1];
        for(int j = n - 2;j > 0;j-- ){
            memo[j] = Math.max(memo[j + 1],nums[j] + (j + 2 < n ? memo[j + 2] : 0));
        }
        int max2 = memo[1];
        return Math.max(max1,max2);
    }
}
