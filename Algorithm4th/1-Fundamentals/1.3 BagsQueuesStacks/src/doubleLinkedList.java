import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

/**
 * @User: Changle
 * @Date: 27/7/2017
 * @Description: 算法第四版-1.3.31
 */


public class doubleLinkedList<Item> {

    private DoubleNode first;
    private DoubleNode last;
    private DoubleNode temp;

    class DoubleNode {

        private DoubleNode next;
        private DoubleNode pre;
        private Item item;
    }

    public doubleLinkedList() {
        first = null;
        last = null;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private void addFirst(Item item) {
        DoubleNode x = new DoubleNode();
        x.item = item;
        if (this.isEmpty()) {
            first = x;
            last = x;
        } else {
            x.next = first;
            first.pre = x;
            first = x;
        }
    }

    private void addLast(Item item) {
        DoubleNode x = new DoubleNode();
        x.item = item;
        if (this.isEmpty()) {
            first = x;
            last = x;
        } else {
            x.pre = last;
            last.next = x;
            last = x;
        }
    }

    private void deleteFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Unsupport Operator!");
        }
        if (first.next == null) {
            temp = first;
            first = null;
            last = null;

        } else {
            temp = first;
            first.next.pre = null;
            first = first.next;
            temp.next = null;
        }
    }

    private void deleteLast() {
        if (isEmpty()) {
            throw new RuntimeException("Unsupport Operator!");
        }
        if (last.pre == null) {
            temp = last;
            first = null;
            last = null;
        } else {
            temp = last;
            last.pre.next = null;
            last = last.pre;
            temp.pre = null;
        }

    }

    private void insertBefore(DoubleNode dbNode, DoubleNode pos) {
        if (dbNode == null) {
            throw new RuntimeException("ERROR!");
        }
        if (pos == first) {
            first.pre = dbNode;
            dbNode.next = first;
            first = dbNode;
        } else {
            dbNode.next = pos;
            pos.pre.next = dbNode;
            dbNode.pre = pos.pre;
            pos.pre = dbNode;
        }
    }

    private void insertAfter(DoubleNode dbNode, DoubleNode pos) {
        if (dbNode == null) {
            throw new RuntimeException("ERROR!");
        }
        if (pos == last) {
            last.next = dbNode;
            dbNode.pre = last;
            last = dbNode;
        } else {
            dbNode.next = pos.next;
            pos.next = dbNode;
            dbNode.pre = pos;
            pos.next.pre = dbNode;
        }

    }

    private void deleteTheNode(DoubleNode dbNode) {
        if (dbNode == null) {
            throw new RuntimeException("ERROR!");
        }
        if (dbNode == first) {
            deleteFirst();
        } else if (dbNode == last) {
            deleteLast();
        } else {
            temp = dbNode;
            dbNode.pre.next = dbNode.next;
            dbNode.next.pre = dbNode.pre;
            dbNode = null;
        }
    }

    private void display() {
        if (first == null) {
            return;
        }
        DoubleNode current = first;
        while (current != null) {
            StdOut.print(current.item + " ");
            current = current.next;
        }
        StdOut.println();
    }

    public DoubleNode getPos(int i)
    {
        if (first == null)
            return null;
        if (i == 1)
            return first;
        int count = 1;
        DoubleNode current = first;
        while (current.next != null)
        {
            current = current.next;
            if (++count == i)
                return current;
        }
        return null;
    }

    public DoubleNode getNode(Item data)
    {
        DoubleNode ret = new DoubleNode();
        ret.item = data;
        return ret;
    }


    public static void main(String[] args) {
        doubleLinkedList<Integer> dl = new doubleLinkedList<>();
        for (int i = 1; i <= 10; ++i) {
            dl.addLast(i);
        }
        dl.addFirst(0);
        dl.display();
        dl.deleteLast();
        dl.deleteFirst();
        dl.display();
        dl.deleteTheNode(dl.getPos(2));
        dl.deleteTheNode(dl.getPos(3));
        dl.display();
        dl.insertBefore(dl.getNode(1), dl.getPos(1));
        dl.insertAfter(dl.getNode(5), dl.getPos(4));
        dl.display();

    }

}
