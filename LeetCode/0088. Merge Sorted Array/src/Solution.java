/**
 * User: Changle
 * Date: 2018-02-09 11:47
 * Source: https://leetcode.com/problems/merge-sorted-array/description/
 */

/*
由于题目中说明 nums1 的长度为 m+n，可以容纳两个数组的所有元素。
所以可以考虑从 nums1 的数组尾部开始填充大数。

时间复杂度：O(n)
空间复杂度：O(1)
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (k >= 0) {
            if (i < 0) {
                nums1[k--] = nums2[j--];
                continue;
            }
            if (j < 0) {
                break;
            }
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}

/*
很容易想到归并，所以使用一个额外数组存放。

时间复杂度：O(n)
空间复杂度：O(n)
 */
class Solution1 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int i = 0;
        int j = 0;
        for (int k = 0; k < res.length; k++) {
            if (i >= m) {
                res[k] = nums2[j++];
            } else if (j >= n) {
                res[k] = nums1[i++];
            } else {
                if (nums1[i] <= nums2[j]) {
                    res[k] = nums1[i++];
                } else {
                    res[k] = nums2[j++];
                }
            }
        }

        for (int k = 0; k < m + n; k++) {
            nums1[k] = res[k];
        }
    }
}
