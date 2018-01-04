/**
 * User: Changle
 * Date: 2017-12-09 10:52
 * Description: 双路快排
 */

public class QuickSort2Ways {

    private static void quickSort(int[] A, int n) {
        quickSort(A, 0, n - 1);
    }

    private static void quickSort(int[] A, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partition(A, lo, hi);
        quickSort(A, lo, p - 1);
        quickSort(A, p + 1, hi);
    }

    private static int partition(int[] A, int lo, int hi) {
        int i = lo + 1, j = hi;
        while (true) {
            while (i <= hi && A[i] < A[lo]) {
                i++;
            }
            while (j >= lo + 1 && A[j] > A[lo]) {
                j--;
            }
            if (i >= j) {
                break;
            }
            exch(A, i, j);
            i++;
            j--;
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
        for (int aA : A) {
            System.out.print(aA + " ");
        }
    }
}
