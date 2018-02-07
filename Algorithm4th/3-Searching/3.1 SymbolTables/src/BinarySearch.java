/**
 * User: Changle
 * Date: 2017-12-20 22:45
 * Description: 二分查找
 */

public class BinarySearch {

    private static int search(int[] A, int target) {
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            //int mid = (l + r) / 2;此处一定要注意两个整数相加溢出的情况
            int mid = l + (r - l) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {8, 12, 14, 17, 26, 27, 28, 35, 36, 44, 44, 48, 54};
        int target = 12;
        int res = search(A, 12);
        System.out.println(res);
    }
}
