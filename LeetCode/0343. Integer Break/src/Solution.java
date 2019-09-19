class Solution {
    public int integerBreak(int n) {
        if(n == 1 || n == 2){
            return 1;
        }

        /**
         * arr[n] 表示将 n 拆分后的积的最大值
         * i -> [1,n - 1],arr[n] = Math.max(i * arr[n - i])
         */
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;

        /*
        从 4 开始，拆分后的积一定不小于原数字。
         */
        for(int i = 4;i <= n;i++){
            int max = 0;
            for(int j = 1;j < i;j++){
                int x = arr[i - j] > i - j ? arr[i - j] : i - j;
                max = (j * x > max) ? j * x : max;
            }
            arr[i] = max;
        }
        return arr[n];
    }
}
