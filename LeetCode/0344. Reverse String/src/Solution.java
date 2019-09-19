/**
 * User: Changle
 * Date: 2018-02-19 00:06
 * Source: https://leetcode.com/problems/reverse-string/description/
 */

/*
使用对撞指针。交换相对位置的字符。

时间复杂度: O(n)
空间复杂度: O(n)
 */
public class Solution {
    public String reverseString(String s) {
        char[] arr = s.toCharArray();
        int i = 0,j = arr.length - 1;
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}


/*
直接调用 jdk 中的方法
 */
class Solution1{
    public String reverseString(String s) {
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }

}
