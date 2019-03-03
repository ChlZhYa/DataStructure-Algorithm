import java.util.Stack;

/**
 * @author: changle
 * @time: 2019-03-03 20:56
 * source: https://leetcode.com/problems/valid-parentheses/
 */
class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c || '[' == c || '{' == c) {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                Character top = stack.pop();
                if (')' == c) {
                    if (top != '(') {
                        return false;
                    }
                } else if (']' == c) {
                    if ('[' != top) {
                        return false;
                    }
                } else if ('}' == c) {
                    if ('{' != top) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
