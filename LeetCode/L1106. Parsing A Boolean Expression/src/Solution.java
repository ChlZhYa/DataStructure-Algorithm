import java.util.*;

public class Solution {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            // 如果是逗号，则直接忽略
            Character curChar = expression.charAt(i);
            if (curChar == ',') {
                continue;
            }
            // 如果非右括号，则入栈
            if (curChar != ')') {
                deque.addLast(curChar);
            }else {
            // 如果是右括号，则开始计算
                Set<Character> set = new HashSet<>();
                while(!deque.isEmpty()){
                    Character peekChar = deque.removeLast();
                    // 如果等于左括号，则开始计算，否则一直移除
                    if (peekChar == '(') {
                        Character operator = deque.removeLast();
                        if (operator == '!') {
                            // 则取反
                            if (set.contains('t')) {
                                deque.addLast('f');
                            } else {
                                deque.addLast('t');
                            }
                        } else if (operator == '&') {
                            // 判断 set 中是否都是 t
                            if (set.contains('f')) {
                                deque.addLast('f');
                            } else {
                                deque.addLast('t');
                            }
                        } else if (operator == '|') {
                            // 判断 set 中是否有 t
                            if (set.contains('t')) {
                                deque.addLast('t');
                            } else {
                                deque.addLast('f');
                            }
                        }
                        set.clear();
                        break;
                    }else {
                        //不是左括号且不是逗号，则将运算符放入集合中
                        if (peekChar != ',') {
                            set.add(peekChar);
                        }
                    }
                }

            }
        }
        // 最后弹出栈顶元素
        Character result = deque.peekLast();
        return result == 't';
    }

}