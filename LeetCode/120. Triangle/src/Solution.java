import java.util.Collections;
import java.util.List;

/**
 * @author Changle
 * @date 2018/10/23 17:49
 */

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        /**
         * 将每个位置的值更新为到该位置的最小和
         */
        for(int i = 1;i < n;i++){
            List<Integer> list = triangle.get(i);
            List<Integer> preList = triangle.get(i - 1);
            for(int j = 0;j <= i;j++){
                int val;
                if(j == 0){
                    val =  list.get(0) + preList.get(0);
                }else if(j == i){
                    val = list.get(j) + preList.get(i - 1);
                }else{
                    val = list.get(j) + Math.min(preList.get(j - 1),preList.get(j));
                }
                list.set(j,val);
            }
        }

        return Collections.min(triangle.get(n - 1));

    }
}
