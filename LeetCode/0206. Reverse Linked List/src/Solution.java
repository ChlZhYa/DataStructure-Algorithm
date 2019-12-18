/**
 * @author changleamazing
 * @date 2019/12/19 00:03
 * source: https://leetcode.com/problems/reverse-linked-list/
 **/
public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
