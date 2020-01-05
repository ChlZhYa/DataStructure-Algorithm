import java.util.Arrays;

/**
 * @author changleamazing
 * @date 2019/12/28 18:36
 * source: https://leetcode.com/problems/rotate-image/
 **/
public class Solution {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 5};
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
