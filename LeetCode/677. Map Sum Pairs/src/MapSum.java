import java.util.HashMap;

/**
 * @author: changle
 * @time: 2019-03-14 01:52
 * source: https://leetcode.com/problems/map-sum-pairs/
 */
public class MapSum {


    Node root;

    class Node {

        int value;
        HashMap<Character, Node> next;

        public Node(int value) {
            value = value;
            next = new HashMap<>();
        }

    }

    public MapSum() {
        root = new Node(0);
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node(0));
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node) {
        int res = node.value;
        for (char c : node.next.keySet()) {
            res += sum(node.next.get(c));
        }
        return res;
    }
}

