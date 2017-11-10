/**
 * User: Changle
 * Date: 2017-11-03 15:21
 * -------------------------------------------------------------------------------------------------------------------
 * Description:
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * -------------------------------------------------------------------------------------------------------------------
 */

public class Solution {

    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length; i++) {
            String reverseString = "";
            for (int j = 0; j < strings[i].length(); j++) {
                reverseString += strings[i].charAt(strings[i].length() - j - 1);
            }
            strings[i] = reverseString;
        }
        String res = "";
        for (int i = 0; i < strings.length - 1; i++) {
            res = res + strings[i] + " ";
        }
        res = res + strings[strings.length - 1];
        return res;
    }
}
