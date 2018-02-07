/**
 * User: Changle
 * Date: 2017-12-27 14:29
 * Description:
 */

public class Solution {

    public class ListNode {

        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode node = head;
        int count = 1;
        while (node.next != null) {
            count++;
            node = node.next;
        }
        for (int i = 0; i < count - k; i++) {
            node = node.next;
        }
        return node;
    }
}
