/**
 * @author: changle
 * @time: 2019-01-15 00:33
 */
public class QuickFindUF {

    /**
     *  并查集中结点的个数
     */
    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    /**
     * 联通 p 和 q 结点
     */
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int index : id) {
            if (id[index] == pid) {
                id[index] = qid;
            }
        }
    }

    /**
     * p 和 q 是否联通
     */
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }
}
