/**
 * User: Changle
 * Date: 2018-02-08 10:34
 * Source: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 */

/*
这个题目没有空间的限制。允许每个元素出现两次。与 26 题不同。
但是考虑到都是保留元素。可以采用与26题相同的策略。
区别在于，这个数组允许保留两个相同元素。所以我们需要设置一个计数器来统计一个元素出现的次数。
依旧用 i 来指向确定值的最后一个元素的位置。
当出现一个新元素的时候，这个新元素的值会被放到第 ++i 位。count 置 0；
当这个元素出现的次数等于 1 时，即这个元素出现了第二次，是合理的，所以继续将这个元素放置到 ++i 位置上。
如果元素继续出现。只移动 j 指针。
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int i = 0, count = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[j - 1]) {
                count++;
                if (count == 1) {
                    nums[++i] = nums[j];
                }
            } else {
                nums[++i] = nums[j];
                count = 0;
            }

        }

        return i + 1;
    }
}
