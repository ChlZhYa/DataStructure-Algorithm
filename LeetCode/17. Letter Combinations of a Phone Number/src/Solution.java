import java.util.ArrayList;
import java.util.List;

/**
 * @author: changle
 * @time: 2019-01-26 04:52
 * Source: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class Solution {

    List<String> result = new ArrayList<>();

    private final String[] letterMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        findCombinations(digits, 0, "");
        return result;
    }

    private void findCombinations(String digits, int index, String currentStr) {
        if (index == digits.length()) {
            result.add(currentStr);
            return;
        }

        // 获得 digits 字符串中索引为 index 的字符
        char c = digits.charAt(index);

        String letters = letterMap[c - '2'];

        // 将该位置的字符串分解为单个字符，每个字符去和之后的字符进行拼接
        for (int i = 0; i < letters.length(); i++) {
            findCombinations(digits, index + 1, currentStr + letters.charAt(i));
        }

    }

}
