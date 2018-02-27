/**
 * User: Changle
 * Date: 2018-02-19 13:27
 */

/*
使用对撞指针。将对应位置的元音字母交换。
将所有的元音字母放在一个字符串中，通过 contains() 判断指针所在的位置是不是元音字母。
更好的处理方式是将十个字符放在 HashSet 中。那么 contains() 方法的复杂度会降低到 O(1)。

时间复杂度: O(n)
空间复杂度：O(n)
 */
public class Solution {

    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            if (!vowels.contains(arr[i] + "")) {
                i++;
                continue;
            }
            if (!vowels.contains(arr[j] + "")) {
                j--;
                continue;
            }
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}
