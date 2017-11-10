import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

/**
 * @User: Changle
 * @Date: 30/7/2017
 * @Description: 算法第四版-1.3.37
 */

public class JosephusQueue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    class Node {

        private Node next;
        private Item item;
    }

    public JosephusQueue() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        Node x = new Node();
        x.item = item;
        if (first == null) {
            first = x;
            last = x;
        } else {
            last.next = x;
            last = last.next;
        }
        N++;
    }

    private Item dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty JosephusQueue");
        }
        Item temp = first.item;
        first = first.next;
        N--;
        if (isEmpty()) {
            last = null;
        }
        return temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new queueIterator();
    }

    public class queueIterator implements Iterator<Item> {

        private Node current = first;
        private Node temp;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            temp = current;
            current = current.next;
            return temp.item;
        }
    }


    public static void main(String[] args) {
        JosephusQueue<Integer> queue = new JosephusQueue<>();
        int N = Integer.parseInt(args[0]);   //人数为N
        int M = Integer.parseInt(args[1]);   //报到M的人出列

        for (int i = 0; i < N; i++) {
            queue.enqueue(new Integer(i));
        }



        //每次将M前面的人重新入列,生成了从M+1开始的队列.
        while (!queue.isEmpty()) {
            for (int i = 0; i < M -1 ; i++) {
                queue.enqueue(queue.dequeue());
            }
            StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println();
    }
}
