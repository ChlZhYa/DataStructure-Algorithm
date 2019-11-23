/**
 * User: Changle
 * Date: 2018-02-20 00:50
 * Source: https://leetcode.com/problems/container-with-most-water/description/
 */

/**
 * 对撞指针。
 * 根据短板理论，装水的容量由最低的墙决定。所以我们要不断调整指向的墙高度 比较低的指针 的位置。
 * 过程中一直计算区域的面积。当两指针相遇，就可以返回最大面积。
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
public class Solution {

    public int maxArea(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return area;
    }
}
