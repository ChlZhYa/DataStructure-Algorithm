import java.util.Arrays;

/**
 * @author changleamazing
 * @date 2020/10/11 18:25
 **/
public class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length == 0){
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        return sum % 2 == 0 && canPartition(nums,sum / 2);

    }

    public boolean canPartition(int[] nums,int sum){
        boolean[][] dp = new boolean[nums.length][sum + 1];
        if(nums[0] <= sum){
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < dp.length; i++) {
            if(nums[i] == sum){
                dp[i][sum] =  true;
                return true;
            }
            for(int j = 0;j < dp[0].length;j++){
                dp[i][j] = dp[i - 1][j];

                if(nums[i] <= j){
                    dp[i][j] |= dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][sum];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        Solution solution = new Solution();
        solution.canPartition(a);
    }

}







