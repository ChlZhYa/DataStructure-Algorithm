/**
 * @author: changle
 * @time: 2019-01-08 00:07
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {

        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int n;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        }
        return root.n;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (key == node.key) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    public void put(Key key, Value value) {
        put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.n = size(node.left) + size(node.right) + 1;

        return node;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public Node floor(Key key) {
        return floor(root, key);
    }

    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return floor(node.left, key);
        } else if (cmp > 0) {
            return floor(node.right, key);
        } else {
            Node r = floor(node.right, key);
            if (r == null) {
                return node;
            } else {
                return r;
            }
        }
    }

    public Node ceiling(Key key) {
        return ceiling(root, key);
    }

    private Node ceiling(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return floor(node.right, key);
        } else if (cmp == 0) {
            return node;
        } else {
            Node l = floor(node.left, key);
            if (l == null) {
                return node;
            } else {
                return l;
            }
        }
    }

    public Key select(int k) {
        return select(root, k);
    }

    private Key select(Node node, int k) {
        if (node == null) {
            return null;
        }
        int t = size(node.left);
        if (t < k - 1) {
            return select(node.right, k - t - 1);
        } else if (t == k - 1) {
            return node.key;
        } else {
            return select(node.left, k);
        }
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if (node == null) {
            return 0;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.left.n + 1;
        } else if (cmp < 0) {
            return rank(node.left, key);
        } else {
            return rank(node.right, key) + node.left.n + 1;
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以 node 为根的 BST
     *
     * @param node 根节点
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.key);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以 node 为根的 BST
     *
     * @param node 根节点
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.key);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历以 node 为根的 BST
     * @param node 根节点
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.right);
        postOrder(node.left);
        System.out.println(node.key);
    }

    /**
     * 删除 key 最小的节点
     *
     * @return 删除最小键之后的树的根节点
     */
    public Node deleteMin() {
        return deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Node deleteMax() {
        return deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node.left;
        }
        node.right = deleteMax(node.right);
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Node delete(Key key) {
        return delete(root, key);
    }

    /**
     * @return 返回删除该结点之后的树的根结点
     */
    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node replacementNode = min(node.right);
            replacementNode.right = deleteMin(node.right);
            replacementNode.left = node.left;
            node = replacementNode;
        } else if (cmp < 0) {
            node.left = delete(node.left, key);
        } else {
            node.right = delete(node.right, key);
        }
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }
}

