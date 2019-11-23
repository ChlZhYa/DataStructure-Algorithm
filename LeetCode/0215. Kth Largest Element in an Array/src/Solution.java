/**
 * User: Changle
 * Date: 2018-02-12 21:38
 */

/**
 * 使用 partition 思想。
 * 用元素 q 去划分数组。左边的数大于 q，右边则小于 q。
 * 然后返回 q 的索引值。 q + 1即代表 q 是数组中的第几大的数。
 * 如果 k 比 q + 1 大。那就从小于 q 的元素中去找。反之则从大于 q 的元素中找。
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }

    public int findKthLargest(int[] nums, int k, int l, int r) {
        int q = partition(l, r, nums);
        if (k == q + 1) {
            return nums[q];
        } else if (k > q + 1) {
            return findKthLargest(nums, k, q + 1, r);
        } else {
            return findKthLargest(nums, k, l, q - 1);
        }
    }

    private int partition(int l, int r, int[] a) {
        int i = l + 1, j = r;
        while (i <= j) {
            if (a[i] >= a[l]) {
                i++;
            } else {
                exch(a, i, j--);
            }
        }
        exch(a, --i, l);
        return i;
    }

    private void exch(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
