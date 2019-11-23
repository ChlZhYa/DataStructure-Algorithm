/**
 * @author Changle
 * @date 2019/11/23 10:08
 * source: https://leetcode.com/problems/longest-palindromic-substring/
 **/

/**
 * 时间复杂度：O(n^3/2)
 */
class Solution {

    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        String result = "";
        // 从最长子串开始判断，直到最短，有回文串则直接退出循环
        for (int i = 0; i < s.length(); i++) {
            int r = s.length();
            while (i < r) {
                String curStr = s.substring(i, r);
                if (isPalindrome(curStr)) {
                    if (curStr.length() > result.length()) {
                        result = curStr;
                    }
                    break;
                }
                r--;
            }
        }
        return result;
    }

    // 是否是回文串
    private boolean isPalindrome(String str) {
        int l = 0;
        int r = str.length() - 1;
        while (l <= r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
