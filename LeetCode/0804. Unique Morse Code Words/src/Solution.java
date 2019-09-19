/**
 * User: Changle
 * Date: 2019-03-01 11:29:16
 * Source: https://leetcode.com/problems/unique-morse-code-words/
 */

class Solution {

    final String[] morseCodes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",
            "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<String>();
        for (String word : words) {
            // 解析成莫斯密码
            set.add(trans2MorseCode(word));
        }
        return set.size();
    }

    private String trans2MorseCode(String word) {
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            result += morseCodes[word.charAt(i) - 'a'];
        }
        return result;
    }
}
