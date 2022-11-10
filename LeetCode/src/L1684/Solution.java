package L1684;

public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0;
        for (String s : words) {
            String word = s;
            for (int j = 0; j < allowed.length(); j++) {
                word = word.replace(String.valueOf(allowed.charAt(j)), "");
            }
            if (word.length() == 0) {
                ans++;
            }
        }
        return ans;
    }

}