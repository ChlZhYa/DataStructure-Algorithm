/**
 * @author Changle
 * @date 2019/9/18 19:35
 * resource: https://leetcode.com/problems/divisor-game/
 */

public class Solution {

    public boolean divisorGame(int N) {
        boolean[] result = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if ((i % j == 0) && (result[i - j] == false)) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[N];
    }
}
