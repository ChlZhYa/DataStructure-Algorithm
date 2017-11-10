import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @User: Changle
 * @Date: 25/7/2017
 * @Description: 算法第四版-1.3.27
 */

public class maxList<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    private class Node {

        private Node next;
        private Item item;
    }

    public maxList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
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


    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString();
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


    //  1.3.27 接受一个结点作为参数,返回链表中键的最大的结点的值.
    public Item max(Node first) throws Exception {
        Item max;
        Node current = first;

        if (first == null) {
            return (Item) new Integer(0);
        } else {
            max = first.item;
            while (current.next != null) {
                current = current.next;
                if (((Comparable) max).compareTo(current.item) < 0) {
                    max = current.item;
                }
            }
        }
        return max;
    }

    // 1.3.28 用递归实现1.3.27
  /*  public Item max(Node node) {
        if (node == null)
            return (Item) new Integer(0);
        if (node.next == null)
            return node.item;
        else {
            Item maxItem = max(node.next);
            return ((Comparable) node.item).compareTo(maxItem) > 0 ? node.item : maxItem;
        }
    }*/

    public static void main(String[] args) throws Exception {
        maxList<Integer> list = new maxList<>();
        list.append(1);
        list.append(3);
        list.append(5);
        list.append(5);
        list.append(3);
        list.append(4);
        list.append(7);
        list.append(2);
        for (Integer i : list) {
            System.out.println(i);
        }

        System.out.println();

        int max = list.max(list.first);

        System.out.println(max);

    }
}

