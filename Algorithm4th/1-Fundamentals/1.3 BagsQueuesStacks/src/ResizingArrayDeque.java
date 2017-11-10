import java.util.Iterator;

/**
 * @User: Changle
 * @Date: 28/7/2017
 * @Description: 算法第四版-1.3.33
 */

public class ResizingArrayDeque<Item> implements Iterable<Item> {

    private int head;
    private int tail;
    private Item[] deque;

    @SuppressWarnings("unchecked")
    public ResizingArrayDeque() {
        deque = (Item[]) new Object[3];
        head = 1;
        tail = 1;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public int size() {
        return tail - head;
    }

    public void pushLeft(Item item) {
        if (head == 0) {
            resize(3 * size());
        }
        deque[--head] = item;
    }

    public void pushRight(Item item) {
        if (tail == deque.length) {
            resize(3 * size());
        }
        deque[tail++] = item;
    }

    public Item popLeft() {
        if (isEmpty()) {
            return null;
        }
        if (size() * 6 < deque.length) {
            resize(size() * 3);
        }
        return deque[head++];
    }

    public Item popRight() {
        if (isEmpty()) {
            return null;
        }
        if (size() * 6 < deque.length) {
            resize(size() * 3);
        }
        return deque[--tail];
    }

    @SuppressWarnings("unchecked")
    private void resize(int size) {
        if (size < 3) {
            size = 3;
        }
        Item tmp[] = (Item[]) new Object[size];
        int j = size / 3;
        for (int i = head; i < tail; i++) {
            tmp[j++] = deque[i];
        }
        deque = tmp;
        head = size / 3;
        tail = j;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<Item> {

        private int current = head;

        @Override
        public boolean hasNext() {
            return current < tail;
        }

        @Override
        public Item next() {
            Item item = deque[current++];
            return item;
        }


    }

    public static void main(String[] args) {
        ResizingArrayDeque<String> deque = new ResizingArrayDeque<>();
        deque.pushLeft("c");
        deque.pushLeft("b");
        deque.pushRight("d");
        deque.pushRight("e");
        System.out.println("deque size: " + deque.size());
        for (String string:deque){
            System.out.println(string);
        }
        System.out.println("Pop up from right: ");
        while (!deque.isEmpty()) {
            System.out.println(deque.popRight());
        }

        deque.pushLeft("c");
        deque.pushLeft("b");
        deque.pushRight("d");
        deque.pushRight("e");
        System.out.println("Pop up from left: ");
        while (!deque.isEmpty()){
            System.out.println(deque.popLeft());
        }
    }

}
