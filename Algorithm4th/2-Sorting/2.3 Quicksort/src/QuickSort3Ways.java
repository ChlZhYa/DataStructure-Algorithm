/**
 * User: Changle
 * Date: 2017-12-09 16:19
 * Description: 三路快排
 */

public class QuickSort3Ways {

    public static int[] quickSort(int[] A, int n) {
        quickSort(A, 0, n - 1);
        return A;
    }

    private static void quickSort(int[] A, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int lt = lo, i = lo + 1, gt = hi + 1;
        int v = A[lo];
        while (i < gt) {
            if (A[i] < v) {
                exch(A, i, ++lt);
                i++;
            } else if (A[i] > v) {
                exch(A, i, --gt);
            } else {
                i++;
            }
        }
        exch(A, lo, lt);
        quickSort(A, lo, lt - 1);
        quickSort(A, gt, hi);
    }

    private static void exch(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = {54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28};
        quickSort(A, A.length);
        for (int aA : A) {
            System.out.print(aA + " ");
        }
    }
}
