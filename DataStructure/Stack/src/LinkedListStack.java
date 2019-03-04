/**
 * @author: changle
 * @time: 2019-03-05 01:24
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;


    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        return "Stack: top "
                + linkedList;
    }
}
