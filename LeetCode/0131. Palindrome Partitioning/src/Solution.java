import java.util.ArrayList;
import java.util.List;

/**
 * @author: changle
 * @time: 2019-01-27 09:53
 * Source: https://leetcode.com/problems/palindrome-partitioning/
 */
public class Solution {

    private List<List<String>> res = new ArrayList();

    public List<List<String>> partition(String s) {
        partition(s, new ArrayList<String>(), 0);
        return res;
    }

    private void partition(String originStr, List<String> list, int index) {
        if (index == originStr.length()) {
            res.add(new ArrayList<>(list));
        }

        for (int i = index + 1; i <= originStr.length(); i++) {
            if (isPalindromeStr(originStr, index, i - 1)) {
                list.add(originStr.substring(index, i));
                partition(originStr, list, i);
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * 判断是否是回文串
     */
    private boolean isPalindromeStr(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != (s.charAt(end))) {
                return false;
            }
            start++;
            end--;

        }
        return true;
    }
}
