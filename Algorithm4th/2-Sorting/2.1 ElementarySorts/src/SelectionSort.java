/**
 * User: Changle
 * Date: 2017-11-30 14:34
 * Description: 选择排序
 */

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {55, 26, 17, 48, 10, 69, 33};
        sort(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min > i) {
                exchange(a, min, i);
            }
        }
    }

    public static void exchange(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
