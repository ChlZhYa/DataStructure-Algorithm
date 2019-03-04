/**
 * @author: changle
 * @time: 2019-03-05 01:39
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node {

        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }

    }

    private Node head, tail;
    private int size;

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Dequeue failed,Queue is empty");
        }
        Node ret = head;
        head = head.next;
        ret.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return ret.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Dequeue failed,Queue is empty");
        }
        return head.e;

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        for (Node cur = head; cur != null; cur = cur.next) {
            res.append(cur).append("->");
        }
        res.append("NULL tail");
        return res.toString();
    }
}
