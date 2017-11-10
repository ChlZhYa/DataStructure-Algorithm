/**
 * @User: Changle
 * @Date: 25/7/2017
 * @Description: 算法第四版—1.3.26
 */

import java.util.LinkedList;
import java.util.ListIterator;

public class removeItemEqualsKey extends LinkedList<String> {
    public removeItemEqualsKey() {
    }

    private static LinkedList<String> remove(LinkedList<String> list, String key) {
        ListIterator iterator = list.listIterator();
        while(iterator.hasNext()) {
            String current = (String)iterator.next();
            if (current.equals(key)) {
                iterator.remove();
            }
        }

        return list;
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("d");
        list.add("c");
        list.add("b");
        list.add("b");

        for (String s:list){
            System.out.println(s);
        }
        System.out.println();

        LinkedList<String> newList = remove(list, "c");

        for (String ss:newList) {

            System.out.println(ss);
        }

    }
}

