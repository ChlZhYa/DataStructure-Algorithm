/**
 * User: Changle
 * Date: 2017-11-12 14:28
 * Description: 优先队列-最大堆
 */

public class PriorityQueue<Key extends Comparable<Key>> {

    private int N;
    private Key[] pq;

    public PriorityQueue(int maxSize) {
        pq = (Key[]) new Comparable[maxSize + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Key max() {
        return pq[1];
    }

    public Key delMax() {
        if (N < 0) {
            System.out.println("队列为空，请先添加元素");
            return null;
        }
        Key max = pq[1];
        exchange(1, N--);
        sink(1);
        return max;
    }

    public void insert(Key v) {
        if (N == pq.length - 1) {
            System.out.println("队列已满，请先删除元素");
        }
        pq[++N] = v;
        swim(N);
    }

    public void swim(int k) {
        while (k / 2 >= 1 && less(k / 2, k)) {
            exchange(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int i) {
        while (2 * i <= N) {
            int j = 2 * i;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            exchange(i, j);
            i = j;
        }
    }


    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public void exchange(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
