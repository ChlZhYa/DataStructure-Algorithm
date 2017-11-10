import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * @User: Changle
 * @Date: 26/7/2017
 * @Description: 算法第四版-1.3.29
 */


public class Queue<Item> implements Iterable<Item> {

    private Node last;
    private int N;

    public Queue() {
        last = null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node x = new Node();
        x.item = item;
        if (isEmpty()) {
            x.next = x;
        } else {
            x.next = last.next;
            last.next = x;
        }
        last = x;
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        Item item = last.next.item;
        if (last.next == last) {
            last = null;
        } else {
            last.next = last.next.next;
        }
        N--;
        return item;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item i : this) {
            s.append(i + "");
        }
        return s.toString();
    }

    class Node {
        private Node next;
        private Item item;
    }


    @Override
    public Iterator iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {
        private int n = N;
        private Node current = last;

        public boolean hasNext() {
            return n > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.next.item;
            current = current.next;
            n--;
            return item;
        }
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue: [ " + q + "])");
    }
}
