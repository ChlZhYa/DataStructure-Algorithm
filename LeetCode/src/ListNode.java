import java.util.List;

/**
 * @author changleamazing
 * @date 2019/12/18 23:15
 **/
public class ListNode {

    final String separator = " -> ";
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void traverse() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            if (cur.next == null) {
                res.append(cur.val).append(";");
            }else {
                res.append(cur.val).append(separator);
            }
            cur = cur.next;
        }
        System.out.println(res);
    }
}

