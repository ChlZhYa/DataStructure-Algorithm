public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head,fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;

            fast = fast.next.next;

            if(slow == fast){
                ListNode cur = head;
                while(cur != slow){
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }
        return null;
    }
}
