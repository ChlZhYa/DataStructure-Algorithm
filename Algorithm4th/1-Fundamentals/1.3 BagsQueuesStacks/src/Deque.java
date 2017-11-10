import java.util.Iterator;

/**
 * @User: Changle
 * @Date: 28/7/2017
 * @Description: 算法第四版-1.3.33
 */


public class Deque<Item> implements Iterable<Item> {

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private class Node {

        public Item item;
        public Node pre;
        public Node next;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void pushLeft(Item item) {
        Node node = new Node();
        node.item = item;
        node.pre = null;
        if (isEmpty()) {
            head = tail = node;
            node.next = null;
        } else {
            head.pre = node;
            node.next = head;
            head = node;
        }
    }

    public void pushRight(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = null;
        if (isEmpty()) {
            head = tail = node;
            node.pre = null;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        size++;
    }

    public Item popLeft() {
        if (isEmpty()) {
            return null;
        } else {
            Item item = head.item;
            if (this.size == 1) {
                head = tail = null;
            } else {
                head = head.next;
                head.pre.next = null;
                head.pre = null;
            }
            size--;
            return item;
        }
    }

    public Item popright(){
        if (isEmpty()) {
            return null;
        }else {
            Item item = tail.item;
            if (size == 1){
                head = tail = null;
            }else {
                tail = tail.pre;
                tail.next.pre = null;
                tail.next = null;
            }
            size--;
            return item;
        }
    }

    @Override
    public Iterator<Item> iterator(){
        return new Iter();
    }

    private class Iter implements Iterator<Item>{
        private Node current = head;

        @Override
        public boolean hasNext(){
            return current != null;
        }

        @Override
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
