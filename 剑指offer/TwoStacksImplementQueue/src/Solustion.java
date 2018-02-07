import java.util.Stack;

/**
 * User: Changle
 * Date: 2017-12-27 10:06
 * Description:
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 时间限制：1秒 空间限制：32768K
 */

public class Solustion {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.add(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }
        int res = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.add(stack2.pop());
        }
        return res;
    }
}
