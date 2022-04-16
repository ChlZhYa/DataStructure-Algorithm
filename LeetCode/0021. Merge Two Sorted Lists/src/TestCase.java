/**
 * @author clz
 * @date 2022/4/16
 *
 */
public class TestCase {

    public static void main(String[] args) {
        ListNode l11 = new ListNode(-9);
        l11.next  = new ListNode(3);
        ListNode l21 = new ListNode(5);
        l21.next = new ListNode(7);
        Solution solution = new Solution();
        ListNode listNode = solution.mergeTwoLists(l11, l21);
        listNode.traverse();
    }

}
