import java.util.HashMap;
import java.util.Map;

/**
 * @author: changle
 * @time: 2019-03-13 00:27
 */

class Trie {

    private Node root;

    class Node {

        public boolean isWord;
        public Map<Character, Node> next;

        public Node() {
            this(false);
        }

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }
    }

    public Trie() {
        root = new Node();
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }

        return cur.isWord;
    }

    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}
