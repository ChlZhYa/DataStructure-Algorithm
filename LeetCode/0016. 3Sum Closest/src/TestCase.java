/**
 * @author clz
 * @date 2022/4/20
 *
 */
public class TestCase {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1, 1, -1, -1, 3};
        int target = -1;
        System.out.println(solution.threeSumClosest(arr, target));
    }

}
