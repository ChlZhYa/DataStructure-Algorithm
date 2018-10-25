import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Changle
 * @date 2018/10/25 11:36
 */

class Solution {
    public int numSquares(int n) {

        int[] memo = new int[n + 1];
        for(int i = 1;i <= n;i++){
            if(Math.pow((int)Math.sqrt(i),2) == i ){
                memo[i] = 1;
                continue;
            }
            memo[i] = i;
            for(int j = (int)Math.floor(Math.sqrt(i));j >= 1;j--){
                memo[i] = Math.min(memo[i],1 + memo[i - j * j]);
            }
        }
        return memo[n];
    }
}
