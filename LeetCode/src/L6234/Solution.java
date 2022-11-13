package L6234;

class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > k || k % nums[i] != 0) {
                continue;
            }
            int cm;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > k || k % nums[j] != 0) {
                    break;
                }
                cm = cmOfArr(nums, i, j);
                if (cm == k) {
                    ans++;
                }
                if (cm > k) {
                    break;
                }
            }
        }
        return ans;
    }

    public int cmOfArr(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int num = findCM(nums[left], nums[left + 1]);
        for (int i = left + 2; i <= right; i++) {
            num = findCM(num, nums[i]);
        }
        return num;

    }

    public int findCM(int m, int n) {
        int min = Math.min(m, n);
        int max = Math.max(m, n);
        int num;
        for (int j = 1; j <= max; j++) {
            num = min * j;
            if (num % max == 0) {
                return num;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,3,4,3};
        Solution solution = new Solution();
        System.out.println(solution.subarrayLCM(arr, 2));
    }
}