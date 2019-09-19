import java.util.ArrayList;
import java.util.List;

/**
 * @author: changle
 * @time: 2019-01-26 14:21
 */
public class Solution2 {

    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) {
            return res;
        }
        breakDownAddress(s,0,"",4);
        return res;
    }

    /**
     * 地址分段
     *
     * @param originalStr 原始的要被分段的字符串
     * @param index 当前未被分段的字符串的索引起始位置
     * @param time 分段次数
     * @param currentStr 已被分段的字符串得到的结果
     */
    private void breakDownAddress(String originalStr, int index, String currentStr, int time) {
        if (time == 0 && index == originalStr.length()) {
            res.add(currentStr);
            return;
        }
        if(time <= 0){
            return;
        }
        // 将接下来的 i 个字符纳入分段结果中
        for (int i = 1; i < 4; i++) {
            if(index + i > originalStr.length()) break;
            String nextSeg = originalStr.substring(index, index + i);
            boolean isGreaterThan255 = nextSeg.length() == 3 && Integer.parseInt(nextSeg) > 255;
            boolean isStartsWithZero = nextSeg.length() > 1 && nextSeg.startsWith("0");
            if (isStartsWithZero || isGreaterThan255) {
                continue;
            }
            breakDownAddress(originalStr, index + i, currentStr + nextSeg + ((time > 1) ? "." : ""),
                    time-1);

        }
    }

}
