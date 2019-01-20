/**
 * @author: changle
 * @time: 2019-01-16 02:45 description：
 */
public class SuccessorWithDelete {

    private int[] id;
    private int[] sz;
    private int[] max;

    public SuccessorWithDelete(int N) {
        sz = new int[N];
        max = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
            max[i] = i;
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

}
