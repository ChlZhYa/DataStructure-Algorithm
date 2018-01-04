/**
 * User: Changle
 * Date: 2017-12-09 10:11
 * Description: 快速排序
 */

public class QuickSort {

    public static int[] quickSort(int[] A, int n) {
        quickSort(A, 0, n - 1);
        return A;
    }

    private static void quickSort(int[] A, int lo, int hi) {
        if (lo >= hi)
            return;
        int p = partition(A, lo, hi);
        quickSort(A, lo, p - 1);
        quickSort(A, p + 1, hi);
    }

    private static int partition(int[] A, int lo, int hi) {
        int v = A[lo], j = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (A[i] < v) {
                exch(A, i, ++j);
            }
        }
        exch(A, lo, j);
        return j;
    }

    private static void exch(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = {54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28};
        quickSort(A, A.length);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
