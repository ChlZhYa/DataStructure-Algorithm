/**
 * User: Changle
 * Date: 2017-12-08 15:26
 * Description: 归并排序
 */

public class MergeSort {
    static int[] aux = new int[0];

    public static int[] mergeSort(int[] A, int n) {
        // write code here
        aux = new int[n];
        mergeSort(A,0,n-1);
        return aux;
    }

    private static void mergeSort(int[] A,int lo,int hi){
        if(lo >= hi)
            return;
        int mid = (lo + hi) / 2;
        mergeSort(A,lo,mid);
        mergeSort(A,mid + 1,hi);
        merge(A,lo,mid,hi);
    }

    private static void merge(int[] A,int lo,int middle,int hi){
        int i = lo,j = middle + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = A[k];
        }
        for(int k = i;k <= hi;k++){
            if(i > middle)
                A[k] = aux[j++];
            else if(j > hi)
                A[k] = aux[i++];
            else if(aux[i] <= aux[j])
                A[k] = aux[i++];
            else
                A[k] = aux[j++];
        }
    }


    public static void main(String[] args) {
        int[] a = {8,7,6,5,4,3,2,1};
        mergeSort(a,8);
        for (int i = 0; i <= 7; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
