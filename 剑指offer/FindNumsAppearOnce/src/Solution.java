import java.util.HashSet;
import java.util.Set;

/**
 * User: Changle
 * Date: 2018-01-31 22:51
 * Description:
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 */

public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Set set = new HashSet();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                set.remove(array[i]);
            } else {
                set.add(array[i]);
            }
        }

        Object[] o = set.toArray();
        num1[0] = (int) o[0];
        num2[0] = (int) o[1];
    }
}