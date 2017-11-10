import java.util.Iterator;

/**
 * @User: Changle
 * @Date: 28/7/2017
 * @Description: 算法第四版-1.3.32
 */


public class Steque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;

    private class Node {

        public Item item;
        public Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = null;
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public void push(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = null;
        if (isEmpty()) {
            first = node;
            last = node;
        } else{
            node.next = first;
            first = node;
        }
    }

    public Item pop(){
        if (isEmpty()){
            return null;
        }
        else {
            Item e = first.item;
            first = first.next;
            return e;
        }
    }

    @Override
    public Iterator<Item> iterator(){
        return new Iter();
    }

    private class Iter implements Iterator<Item>{
        private Node current = first;

        @Override
        public boolean hasNext(){
            return current != null;
        }

        @Override
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Steque<String> s = new Steque<>();
        s.enqueue("d");
        s.enqueue("e");
        s.enqueue("f");
        s.push("c");
        s.push("b");
        s.push("a");
        System.out.println("Steque is:");
        for (String string:s){
            System.out.println(string);
        }

        System.out.println("pop up:");
        while (!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
