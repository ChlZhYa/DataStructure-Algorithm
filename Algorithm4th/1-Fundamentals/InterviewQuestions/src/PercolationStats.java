import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * @author: changle
 * @time: 2019-01-21 00:51
 * Source：http://coursera.cs.princeton.edu/algs4/assignments/percolation.html
 * 2019-01-21 03:05:31 score: 81%
 */

public class PercolationStats {

    private static final double COEFFICIENT = 1.96;
    private final double[] perthreshold;
    private final double mean;
    private final double stddev;

    public PercolationStats(int n, int trials) {
        perthreshold = new double[trials];

        Percolation percolation = new Percolation(n);

        for (int i = 0; i < trials; i++) {
            //打开的 site 的个数
            int count = 0;
            while (!percolation.percolates()) {
                int a, b;
                do {
                    a = StdRandom.uniform(1, n + 1);
                    b = StdRandom.uniform(1, n + 1);
                } while (percolation.isOpen(a, b));

                percolation.open(a, b);
                count++;
            }
            perthreshold[i] = (double) count / (n * n);
        }

        mean = StdStats.mean(perthreshold);
        stddev = StdStats.stddev(perthreshold);
    }

    public double mean() {
        return mean;
    }

    public double stddev() {
        return stddev;
    }

    public double confidenceLo() {
        return mean - ((COEFFICIENT * stddev) / Math.sqrt(perthreshold.length));
    }

    public double confidenceHi() {
        return mean + ((1.96 * stddev) / Math.sqrt(perthreshold.length));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats percolationStatsCase = new PercolationStats(n, trials);
        StdOut.printf("%-24s", "mean");
        StdOut.printf("= %.16f\n", percolationStatsCase.mean());
        StdOut.printf("%-24s", "stddev");
        StdOut.printf("= %.18f\n", percolationStatsCase.stddev());
        StdOut.printf("%-24s", "95% confidence interval");
        StdOut.printf("= %.16f, %.16f\n", percolationStatsCase.confidenceLo(),
                percolationStatsCase.confidenceHi());
    }
}
