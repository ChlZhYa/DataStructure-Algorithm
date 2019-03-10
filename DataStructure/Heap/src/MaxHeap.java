/**
 * @author Changle
 * @date 2019/3/8 18:03
 */

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            shiftDown(i);
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回父亲结点的索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("Root doesn't have parent");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回左孩子结点的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回右孩子结点的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        shiftUp(data.getSize() - 1);
    }

    private void shiftUp(int index) {
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            data.swap(index, parent(index));
            index = parent(index);
        }
    }

    /**
     * 查找堆中最大值
     */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("heap is empty");
        }
        return data.get(0);
    }

    /**
     * 取出堆中最大元素
     */
    public E extractMax() {
        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        shiftDown(0);

        return ret;
    }

    private void shiftDown(int index) {
        while (leftChild(index) < data.getSize()) {
            int j = leftChild(index);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j++;
            }
            if (data.get(index).compareTo(data.get(j)) > 0) {
                break;
            }
            data.swap(index, j);
            index = j;
        }
    }

    /**
     * 取出对顶的最大元素，并且替换成元素 e
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        shiftDown(0);
        return ret;
    }
}
