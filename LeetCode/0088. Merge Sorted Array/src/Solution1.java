/**
 * @author changleamazing
 * @date 2019/11/23 12:31
 **/

/**
 * 很容易想到归并，所以使用一个额外数组存放。
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
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

        if (m + n >= 0) {
            System.arraycopy(res, 0, nums1, 0, m + n);
        }
    }
}
