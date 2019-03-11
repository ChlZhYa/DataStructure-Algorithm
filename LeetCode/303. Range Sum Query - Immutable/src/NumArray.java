/**
 * 线段树
 * @author Changle
 * @date 2019/3/11 15:35
 */

class NumArray {

    private int[] tree;
    private int[] data;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            data = nums;
            tree = new int[4 * nums.length];

            buildSegmentTree(0, 0, data.length - 1);
        }
    }

    private void buildSegmentTree(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }

        int mid = left + (right - left) / 2;
        int leftChild = 2 * treeIndex + 1;
        int rightChild = 2 * treeIndex + 2;
        buildSegmentTree(leftChild, left, mid);
        buildSegmentTree(rightChild, mid + 1, right);

        tree[treeIndex] = tree[leftChild] + tree[rightChild];

    }

    public int sumRange(int i, int j) {
        if (data.length == 0) {
            return 0;
        }
        return sumRange(0, 0, data.length - 1, i, j);
    }

    private int sumRange(int treeIndex, int left, int right, int queryL, int queryR) {
        if (left == queryL && right == queryR) {
            return tree[treeIndex];
        }

        int mid = left + (right - left) / 2;
        int leftChild = 2 * treeIndex + 1;
        int rightChild = 2 * treeIndex + 2;

        if (queryL >= mid + 1) {
            return sumRange(rightChild, mid + 1, right, queryL, queryR);
        } else if (queryR <= mid) {
            return sumRange(leftChild, left, mid, queryL, queryR);
        } else {
            int leftResult = sumRange(leftChild, left, mid, queryL, mid);
            int rightResult = sumRange(rightChild, mid + 1, right, mid + 1, queryR);
            return leftResult + rightResult;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
