/**
 * @author: changle
 * @time: 2019-01-16 02:07 description： Add a method find() to the union-find data type so that
 * find(i) returns the largest element in the connected component containing i. The operations,
 * union(),connected(), and find() should all take logarithmic time or better. For example, if one
 * of the connected components is {1, 2, 6, 9}, then find() method should return 99 for each of the
 * four elements in the connected components.
 */
public class FindLargestUF {

    private int[] id;
    private int[] sz;
    private int[] max;
    private boolean[] isRemove;

    public FindLargestUF(int N) {
        id = new int[N];
        sz = new int[N];
        max = new int[N];
        isRemove = new boolean[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
            max[i] = i;
            isRemove[i] = false;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    /**
     * 找到包含 i 的连通分量中最大值
     */
    public int find(int i) {
        return max[root(i)];
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        if (connected(p, q)) {
            return;
        }
        int rootOfP = root(p);
        int rootOfQ = root(q);
        if (sz[rootOfP] > sz[rootOfQ]) {
            id[rootOfQ] = rootOfP;
            sz[rootOfP] += sz[rootOfQ];
            max[rootOfP] = Math.max(max[rootOfP], max[rootOfQ]);
        } else {
            id[rootOfP] = rootOfQ;
            sz[rootOfQ] += sz[rootOfP];
            max[rootOfQ] = Math.max(max[rootOfP], max[rootOfQ]);
        }
    }

    public void remove(int x) {
        isRemove[x] = true;
        if (x > 0 && isRemove[x - 1]) {
            union(x, x - 1);
        }
        if (x < isRemove.length - 1 && isRemove[x + 1]) {
            union(x, x + 1);
        }
    }

    public int getSuccessor(int x) {
        if (x < 0 || x > isRemove.length - 1) {
            throw new IllegalArgumentException("访问越界!");
        } else if (isRemove[x]) {
            if (find(x) + 1 > isRemove.length - 1) {
                return -1;
            } else {
                return find(x) + 1;
            }
        } else {
            return x;
        }
    }

}
