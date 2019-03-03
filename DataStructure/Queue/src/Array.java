/**
 * @author: changle
 * @time: 2019-03-02 12:03
 */
public class Array<E> {

    private E[] data;
    /**
     * 数组中存放的元素的个数
     */
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    /**
     * 返回数组中存放的元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在 index = 0 处添加元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在元素末尾添加新元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在数组指定位置添加元素
     */
    public void add(int index, E e) {
        if (index < 0 | index > size) {
            throw new IllegalArgumentException("Add failed.Index is illegal");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }

        //     向右移动元素
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    /**
     * 将数组容量改变为 i
     */
    private void resize(int newCapacity) {
        E[] ret = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            ret[i] = data[i];
        }
        data = ret;
    }

    /**
     * 获取数组第一个元素
     */
    E getFirst() {
        return get(0);
    }

    /**
     * 获取索引为 index 的元素
     */
    E get(int index) {
        if (index < 0 | index >= size) {
            throw new IllegalArgumentException("get faild。Index is illegal");
        }
        return data[index];
    }

    /**
     * 设置索引为 index 的元素的值
     */
    void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set faild。Index is illegal");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素 e
     */
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素 e 所在的索引
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除 index 位置的元素，返回删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("delete faild,Index is illegal");
        }
        E res = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
        // 防止复杂度震荡
        if (size == data.length >> 2 && data.length / 2 != 0) {
            resize(data.length >> 1);
        }
        return res;
    }

    /**
     * 从数组中删除第一个元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除第一个 e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }


}
