/**
 * @author: changle
 * @time: 2019-03-03 18:15
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
