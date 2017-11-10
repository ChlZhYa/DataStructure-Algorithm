import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

/**
 * @User: Changle
 * @Date: 30/7/2017
 * @Description: 算法第四版-1.3.36
 */

public class RandomQueueIterator<Item> implements Iterable<Item> {

    private Item[] arr = (Item[]) new Object[1];
    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int cap) {
        Item[] temp = (Item[]) new Object[cap];
        for (int i = 0; i < N; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public void enqueue(Item item) {
        if (N == arr.length) {
            resize(2 * arr.length);
        }
        arr[N++] = item;
    }

    public Item dequeue() {
        int index = StdRandom.uniform(N);
        Item indexTemp = arr[index];
        arr[index] = arr[--N];
        arr[N] = indexTemp;
        Item temp = arr[N];
        arr[N] = null;
        if (N == arr.length / 4) {
            resize(arr.length / 2);
        }
        return temp;
    }

    public Item sample() {
        int index = StdRandom.uniform(N);
        return arr[index];
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    public class RandomIterator implements Iterator<Item> {

        int[] randomArray = randomIntArray(N);
        int size = N;

        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public Item next() {
            return arr[randomArray[--size]];
        }
    }

    //随机打乱数组
    private int[] randomIntArray(int N) {
        int[] tmp = new int[N];

        for (int i = 0; i < N; i++) {
            tmp[i] = i;
        }
        for (int i = N; i > 0; i--) {
            int index = StdRandom.uniform(i);

            int temp = tmp[index];
            tmp[index] = tmp[i - 1];
            tmp[i - 1] = temp;
        }
        return tmp;
    }

    public static void main(String[] args) {
        RandomQueueIterator<Integer> queue = new RandomQueueIterator<>();
        for (int i = 0; i < 7; i++) {
            queue.enqueue(i);
        }

        for (int i : queue)
            StdOut.print(i + " ");
    }
}
