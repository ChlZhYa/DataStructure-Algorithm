import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * @author: changle
 * @time: 2019-01-16 01:42
 * @description：Social network connectivity. Given a social network containing n members and a log
 * file containing m timestamps at which times pairs of members formed friendships, design an
 * algorithm to determine the earliest time at which all members are connected (i.e., every member
 * is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by
 * timestamp and that friendship is an equivalence relation. The running time of your algorithm
 * should be mlogn or better and use extra space proportional to n.
 */
public class SocialNetworkConnectivity {

    public static void main(String[] args) {
        WeightedQuickUnionUF uf = null;
        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            if (uf == null) {
                uf = new WeightedQuickUnionUF(Integer.valueOf(line));
            }

            String[] arrOfLine = line.split(" ");
            int p = Integer.parseInt(arrOfLine[1]);
            int q = Integer.parseInt(arrOfLine[2]);
            if (!uf.connected(p, q)) {
                uf.union(p, q);
            }
            if (uf.count() == 1) {
                StdOut.println(arrOfLine[0]);
                return;
            }
        }
    }
}
