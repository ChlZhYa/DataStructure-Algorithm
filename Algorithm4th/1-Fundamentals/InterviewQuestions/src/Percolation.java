import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * @author: changle
 * @time: 2019-01-17 21:30
 */


public class Percolation {

    /**
     * site打开状态
     */
    private final boolean[][] site;

    /**
     * 网格的边长
     */
    private final int n;
    /**
     * 开放站点的数量
     */
    private int count = 0;

    /**
     * 并查集
     */
    private final WeightedQuickUnionUF uf;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        this.n = n;
        site = new boolean[n][n];
        //    初始化网站状态
        for (int i = 0; i < site.length; i++) {
            for (int j = 0; j < site[0].length; j++) {
                site[i][j] = false;
            }

        }
        //    初始化并查集,新增的结点为头部和底部的两个虚拟结点
        uf = new WeightedQuickUnionUF(n * n + 2);
    }


    /**
     * 打开 (row,site) 的网站
     */
    public void open(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException();
        }
        if (isOpen(row, col)) {
            return;
        }
        site[row - 1][col - 1] = true;
        if (row == 1) {
            uf.union(0, col);
            if (n == 1) {
                uf.union(col, n * n + 1);
            }
            if (n >= 2 && isOpen(row + 1, col)) {
                uf.union(col, n + col);
            }
            count++;
            return;
        }
        if (row == n) {
            uf.union(n * n + 1, n * n - n + col);
            if (isOpen(n - 1, col)) {
                uf.union(n * n - n + col, n * n - 2 * n + col);
            }
            count++;
            return;
        }
        //此时必定存在 n >= 3
        if (col == 1) {
            if (isOpen(row - 1, 1)) {
                uf.union((row - 1) * n + 1, (row - 2) * n + 1);
            }
            if (isOpen(row + 1, 1)) {
                uf.union((row - 1) * n + 1, row * n + 1);
            }
            if (isOpen(row, 2)) {
                uf.union((row - 1) * n + 1, (row - 1) * n + 2);
            }
            count++;
            return;
        }
        if (col == n) {
            if (isOpen(row - 1, n)) {
                uf.union((row - 1) * n, row * n);
            }
            if (isOpen(row + 1, n)) {
                uf.union(row * n, (row + 1) * n);
            }
            if (isOpen(row, n - 1)) {
                uf.union(row * n, row * n - 1);
            }
            count++;
            return;
        }
        //    四边都是 site 的点
        if (isOpen(row - 1, col)) {
            uf.union((row - 1) * n + col, (row - 2) * n + col);
        }
        if (isOpen(row + 1, col)) {
            uf.union((row - 1) * n + col, row * n + col);
        }
        if (isOpen(row, col - 1)) {
            uf.union((row - 1) * n + col, (row - 1) * n + col - 1);
        }
        if (isOpen(row, col + 1)) {
            uf.union((row - 1) * n + col, (row - 1) * n + col + 1);
        }
        count++;
    }

    public boolean isOpen(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException();
        }
        return site[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException();
        }
        return uf.connected(0, (row - 1) * n + col);
    }

    /**
     * 开放 site 的数量
     */
    public int numberOfOpenSites() {
        return count;
    }

    /**
     * 是否渗透
     */
    public boolean percolates() {
        return uf.connected(0, n * n + 1);
    }


    //    public static void main(String[] args) {
    //    Percolation percolation = new Percolation(6);
    //    percolation.open(1, 6);
    //    System.out.println(percolation.isFull(1,6));
    //}
}
