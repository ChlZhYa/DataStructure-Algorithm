/**
 * @author Changle
 * @date 2019/11/22 16:37
 * source: https://leetcode.com/problems/add-two-numbers/
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode last, dummyHead = new ListNode(0);
        last = dummyHead;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            last.next = new ListNode(sum % 10);
            sum /= 10;
            last = last.next;
        }

        if (sum == 1) {
            last.next = new ListNode(1);
        }

        return dummyHead.next;
    }
}
