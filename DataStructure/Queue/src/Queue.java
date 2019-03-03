/**
 * @author: changle
 * @time: 2019-03-04 01:51
 */
public interface Queue<E> {

    /**
     * 入队
     */
    void enqueue(E e);

    /**
     * 出队，返回出队的元素值
     */
    E dequeue();

    /**
     * 获取队首元素的值
     */
    E getFront();

    /**
     * 返回队列的元素个数
     */
    int getSize();

    /**
     * 队列是否为空
     */
    boolean isEmpty();
}
