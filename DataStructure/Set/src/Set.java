/**
 * @author Changle
 * @date 2019/3/1 10:28
 */

public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();

}
