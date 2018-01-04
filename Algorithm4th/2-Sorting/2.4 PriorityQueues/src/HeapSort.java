/**
 * User: Changle
 * Date: 2017-12-03 09:22
 * Description: 堆排序
 */

public class HeapSort {

    public static int[] heapSort(int[] A, int n) {
        // 最大堆的构造
        for (int i = n / 2 - 1; i >= 0; i--) {
            sink(A, i, n);
        }

        // 排序
        for (; n > 1; ) {
            exch(A, 0, --n);
            sink(A, 0, n);
        }
        return A;
    }

    public static void sink(int[] A, int i, int n) {
        while (2 * i + 1 < n) {
            int j = 2 * i + 1;
            if (j + 1 < n && A[j] < A[j + 1]) {
                j++;
            }
            if (A[i] < A[j]) {
                exch(A, i, j);
            } else {
                break;
            }
            i = j;
        }
    }

    public static void exch(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = {54,35,48,36,27,12,44,44,8,14,26,17,28};
        heapSort(A, A.length);
        for (int a : A) {
            System.out.print(a + " ");
        }
    }
}
