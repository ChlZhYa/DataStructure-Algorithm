/**
 * User: Changle
 * Date: 2017-11-05 10:52
 * -------------------------------------------------------------------------------------------------------------------
 * Description:
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves,
 * judge if this robot makes a circle, which means it moves back to the original place.
 * Example 1:
 * Input: "UD"
 * Output: true
 * Example 2:
 * Input: "LL"
 * Output: false
 */


public class Solution {

    public boolean judgeCircle(String moves) {
        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == ('L')) {
                left++;
            } else if (moves.charAt(i) == ('R')) {
                right++;
            } else if (moves.charAt(i) == ('U')) {
                up++;
            } else {
                down++;
            }
        }
        return left == right && up == down;
    }

}