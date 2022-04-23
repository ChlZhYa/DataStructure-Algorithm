public class TestCase {

    public static void main(String[] args) {
//        ListNode listNode = new ListNode(3);
//        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(0);
//        ListNode listNode3 = new ListNode(-4);
//        listNode.next = listNode1;
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode1;
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(0);
        listNode1.next = listNode;
        listNode.next = listNode1;
        Solution solution = new Solution();
        ListNode result = solution.detectCycle(listNode);
        System.out.println(result.val);
    }
}
