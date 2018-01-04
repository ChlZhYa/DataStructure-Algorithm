/**
 * User: Changle
 * Date: 2017-12-05 10:12
 * Description: 冒泡排序
 */

public class BubbleSort {

    public static int[] bubbleSort(int[] A) {
        for(int i = 0;i < A.length - 1;i++){
            for(int j = 0;j < A.length - i - 1;j++){
                if(A[j] > A[j + 1]){
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] =temp;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {5, 4, 3, 2, 1};
        bubbleSort(A);
        for (int a : A) {
            System.out.print(a + " ");
        }
    }
}
