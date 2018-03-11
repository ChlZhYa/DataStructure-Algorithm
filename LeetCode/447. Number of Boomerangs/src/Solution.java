import java.util.HashMap;

/**
 * User: Changle
 * Date: 2018-03-11 13:18
 * Source: https://leetcode.com/problems/number-of-boomerangs/description/
 */

/*
固定一个点，遍历其它的点。将距离与个数放入 hashmap 中。
将每个点的结果相加。

时间复杂度: O(n^2)
空间复杂度: O(n)
 */
public class Solution {

    public static int numberOfBoomerangs(int[][] points) {
        int res = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    if (hashMap.containsKey(distance(points[i], points[j]))) {
                        hashMap.put(distance(points[i], points[j]),
                                hashMap.get(distance(points[i], points[j]))+ 1);
                    } else {
                        hashMap.put(distance(points[i], points[j]), 1);
                    }
                }
            }

            for (int val : hashMap.values()) {
                res += val * (val - 1);
            }

            hashMap.clear();
        }
        return res;
    }

    private static int distance(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }

    public static void main(String[] args) {
        int[][] a = {{0, 0}, {1, 0}, {2, 0}};
        numberOfBoomerangs(a);
    }
}
