import java.util.Arrays;

/**
 * @author changleamazing
 * @date 2019/12/29 00:49
 * source: https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/submissions/
 **/
public class Solution {

    public int findBestValue(int[] arr, int target) {
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 1, arr.length);
        Arrays.sort(newArr);
        int length = newArr.length;

        // 如果总和比 target 还小，则不需要替换。
        if (Arrays.stream(newArr).sum() <= target) {
            return newArr[length - 1];
        }
        // 已经遍历过的数字的和
        int sum = 0;
        // 剩下的数字个数
        int leftNum;
        // 剩下的数字和达到 target 需要的平均数
        double leftAverage;
        for (int i = 0; i < length - 1; i++) {
            sum += newArr[i];
            leftNum = length - i - 1;
            leftAverage = (target - sum) / (double) leftNum;
            // 如果平均数比下一个数小，则说明后面的数都要被替换
            if (leftAverage <= newArr[i + 1]) {
                // 如果 leftAverage <= x.5 ，则取 Math.floor(leftAverage);否则相反
                return (int) (leftAverage - Math.floor(leftAverage) <= 0.5 ? Math.floor(leftAverage)
                        : Math.ceil(leftAverage));
            }
        }
        return target - sum;
    }

    public static void main(String[] args) {
        int[] arr = {20693, 79539, 84645, 66727, 81334, 185, 14263, 53984, 71844, 71546};
        new Solution().findBestValue(arr, 39947);

    }
}