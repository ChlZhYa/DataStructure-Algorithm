import java.util.ArrayList;
import java.util.List;

/**
 * @author: changle
 * @time: 2019-01-26 07:15
 * Source: https://leetcode.com/problems/restore-ip-addresses/
 */

public class Solution {
    private List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4){
            return res;
        }
        piecewise(s,"",0,3);
        return res;

    }

    private void piecewise(String s,String curStr,int index, int time){
        // 如果剩下的位数比 分解次数 * 3 还多，说明该分解方式不行
        if(s.length() - index > (time + 1) * 3) {
            return;
        }

        if(index >= s.length()) {
            return;
        }

        String nextSeg;

        if(time == 0 ){
            nextSeg = s.substring(index);
            if(nextSeg.length() == 1 || (Integer.parseInt(nextSeg) <= 255 & !nextSeg.startsWith("0"))) {
                res.add(curStr + nextSeg);
            }
            return;
        }

        // 将一个字符分为一段
        piecewise(s,curStr + s.substring(index,index+1) + ".",index + 1,time - 1);

        // 将两个字符分为一段
        if(index + 2 <= s.length()){
            nextSeg = s.substring(index,index + 2);
            if(!nextSeg.startsWith("0")) {
                piecewise(s,curStr + nextSeg + ".",index + 2,time - 1);
            }
        }


        // 将三个字符分为一段
        if(index + 3 <= s.length()){
            nextSeg = s.substring(index,index + 3);
            if(Integer.parseInt(nextSeg) <= 255 && !nextSeg.startsWith("0")) {
                piecewise(s,curStr + nextSeg + ".",index + 3,time - 1);
            }
        }
    }

}
