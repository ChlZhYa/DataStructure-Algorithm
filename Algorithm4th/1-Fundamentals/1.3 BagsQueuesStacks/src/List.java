import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @User: Changle
 * @Date: 27/7/2017
 * @Description: 算法第四版-1.3.30
 */


public class List<Item> implements Iterable<Item> {

    private int N;
    private Node first;
    private Node last;

    private class Node {

        private Item item;
        private Node next;
    }

    public List() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void append(Item item) {
        Node x = new Node();
        x.item = item;
        if (isEmpty()) {
            first = x;
            last = x;
        } else {
            last.next = x;
            last = x;
        }
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


    public void reverseRec() {
        first = reverseRec(first);
    }

    private Node reverseRec(Node node) {
        return reverseRec(node, null);
    }

    private Node reverseRec(Node srcFirst, Node destFirst) {
        if (srcFirst == null) {
            return destFirst;
        } else {
            Node next = srcFirst.next;
            srcFirst.next = destFirst;
            return reverseRec(next, srcFirst);
        }
    }

    public static void main(String[] args) {
        List<String> list1 = new List<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            list1.append(s);
        }

        list1.reverseRec();
        for (String s : list1) {
            System.out.print(s + " ");
        }
    }
}