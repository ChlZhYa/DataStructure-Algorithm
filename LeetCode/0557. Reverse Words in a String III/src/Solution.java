/**
 * @author changleamazing
 * @date 2020/8/30 14:43 source: https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 **/
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] ch = s.toCharArray();
        int left = 0, right;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ' || i == ch.length - 1) {
                right = ch[i] == ' ' ? i - 1 : ch.length - 1;
                swap(ch, left, right);
                left = i + 1;
            }
        }
        return String.valueOf(ch);
    }

    private void swap(char[] ch, int left, int right) {
        while (left < right) {
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
    }
}
