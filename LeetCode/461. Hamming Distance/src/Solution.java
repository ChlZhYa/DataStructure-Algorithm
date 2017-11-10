/**
 * Created with IntelliJ IDEA.
 * User: Changle
 * Date: 2017-11-03 15:12
 * -------------------------------------------------------------------------------------------------------------------
 * Description:
 * <p>
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * <p>
 * Example:
 * Given two integers x and y, calculate the Hamming distance.
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 * -------------------------------------------------------------------------------------------------------------------
 */


public class Solution {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (xor >> i) & 1;
        }
        return count;
    }
}
