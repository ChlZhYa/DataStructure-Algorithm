/**
 * @author changleamazing
 * @date 2019/12/29 01:16
 * source: https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
 **/
public class Solution {

    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int[] temp = new int[len];
        arr[len - 1] = -1;
        for (int i = len - 2; i >= 0; i--) {
            temp[i] = Math.max(arr[i + 1], temp[i + 1]);
        }
        return temp;
    }
}
