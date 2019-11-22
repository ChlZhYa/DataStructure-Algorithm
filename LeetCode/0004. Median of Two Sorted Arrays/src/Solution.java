/**
 * @author Changle
 * @date 2019/11/22 15:26
 * source: https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

public class Solution {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // merge sort
        int m = 0;
        int n = 0;
        int i = 0;
        int[] resultArray = new int[nums1.length + nums2.length];
        if (resultArray.length == 0) {
            return 0;
        }
        while (m < nums1.length && n < nums2.length) {
            if (nums1[m] <= nums2[n]) {
                resultArray[i++] = nums1[m++];
            } else {
                resultArray[i++] = nums2[n++];
            }
        }
        while (m < nums1.length) {
            resultArray[i++] = nums1[m++];
        }
        while (n < nums2.length) {
            resultArray[i++] = nums2[n++];
        }
        if (resultArray.length % 2 != 0) {
            return resultArray[resultArray.length / 2];
        } else {
            return (resultArray[resultArray.length / 2] + resultArray[resultArray.length / 2 - 1]) / 2.0d;
        }
    }
}
