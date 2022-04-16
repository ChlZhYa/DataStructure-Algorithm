/**
 * @author Changle
 * @date 2019/6/26 9:36
 * source: <a href="https://leetcode.com/problems/merge-two-sorted-lists/">https://leetcode.com/problems/merge-two-sorted-lists/</a>
 * T(n): O(l1.len + l2.len)
 * S(n): O(l1.len + l2.len)
 */

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;

        return dummy.next;

    }
}
