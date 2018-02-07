import java.util.ArrayList;
import java.util.Stack;

/**
 * User: Changle
 * Date: 2017-12-26 20:29
 * Description:
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * 时间限制：1秒 空间限制：32768K
 */

public class Solution {

    public class ListNode {

        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack s = new Stack();

        while (listNode!= null) {
            s.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!s.empty()) {
            arrayList.add((Integer) s.pop());
        }

        return arrayList;

    }


}
