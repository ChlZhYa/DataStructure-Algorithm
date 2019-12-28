import java.util.HashMap;

/**
 * @author changleamazing
 * @date 2019/12/28 11:08
 * source:
 **/
public class Solution {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger > desiredTotal) {
            return true;
        }
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) {
            return false;
        }
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        return canIWin(maxChoosableInteger, desiredTotal, 0, hashMap);
    }

    private boolean canIWin(int length, int target, int used, HashMap<Integer, Boolean> hashMap) {
        if (hashMap.get(used) != null) {
            return hashMap.get(used);
        }
        for (int i = 0; i < length; i++) {
            int curBitIndex = 1 << i;// 表示 used 中的位数
            if ((curBitIndex & used) == 0) {
                if (i + 1 >= target || !canIWin(length, target - i - 1, used | curBitIndex,
                        hashMap)) {
                    hashMap.put(used, true);
                    return true;
                }
            }
        }
        hashMap.put(used, false);
        return false;
    }
}