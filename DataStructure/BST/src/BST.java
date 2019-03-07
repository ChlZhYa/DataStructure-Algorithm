import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Changle
 * @date 2019/2/27 17:25
 */

public class BST<E extends Comparable<E>> {

    private class Node {

        private E e;

        private int N;

        Node left, right;

        Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    /**
     * 根结点
     */
    private Node root;

    /**
     * @return 返回 以 node 为根的 BST 结点的个数
     */
    int size() {
        return size(root);
    }


    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    boolean isEmpty() {
        return size(root) == 0;
    }

    /**
     * 向 BST 中插入结点 e
     */
    public void add(E e) {
        root = add(e, root);
    }

    private Node add(E e, Node node) {
        if (node == null) {
            return new Node(e);
        }
        int cmp = e.compareTo(node.e);
        // 如果插入结点的值小于该结点，则插入左子树，否则插入右子树
        if (cmp < 0) {
            node.left = add(e, node.left);
        } else if (cmp > 0) {
            node.right = add(e, node.right);
        }
        // 更新结点个数
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    /**
     * 查询该 BST 中是否包含元素 e
     */

    public boolean contains(E e) {
        return contains(e, root);
    }

    private boolean contains(E e, Node node) {
        if (node == null) {
            return false;
        }
        //    如果查询结点的值小于该结点，则查询左子树；查询结点的值等于该结点，则返回 true;否则查询右子树
        int cmp = e.compareTo(node.e);
        if (cmp < 0) {
            return contains(e, node.left);
        } else if (cmp == 0) {
            return true;
        } else {
            return contains(e, node.right);
        }
    }

    /**
     * 先序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 非递归遍历
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 返回最小值
     */
    public Node min() {
        return min(root);
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


    /**
     * 删除最小元素
     */
    public Node deleteMin() {
        if (root == null) {
            return null;
        }
        return deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        } else {
            node.left = deleteMin(node.left);
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    /**
     * 删除最大元素
     */
    public Node deleteMax() {
        if (root == null) {
            return null;
        }
        return deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null) {
            return node.left;
        } else {
            node.right = deleteMin(node.right);
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    /**
     * 删除元素
     */
    public Node delete(E e) {
        return delete(e, root);
    }

    private Node delete(E e, Node node) {
        if (node == null) {
            return null;
        }
        int cmp = e.compareTo(node.e);
        if (cmp < 0) {
            node.left = delete(e, node.left);
        } else if (cmp > 0) {
            node.right = delete(e, node.right);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以 node 为根节点，深度为 depth 的描述二叉树的字符串
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth)).append("null\n");
            return;
        }
        res.append(generateDepthString(depth)).append(node.e).append("\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

}
