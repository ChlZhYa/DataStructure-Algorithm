/**
 * @author changleamazing
 * @date 2020/1/5 10:32
 * source: https://leetcode-cn.com/contest/weekly-contest-170/problems/decrypt-string-from-alphabet-to-integer-mapping/
 **/
public class Solution {

    public String freqAlphabets(String s) {
        String res = "";
        int index = 0;
        int endPoint;
        while (s.indexOf('#', index) != -1) {
            endPoint = s.indexOf('#', index) - 2;
            while (index < endPoint) {
                res = res + ((char) (s.charAt(index) - '1' + 'a'));
                index++;
            }
            char c = (char) (Integer.parseInt(s.substring(index, index + 2)) - 1 + 'a');
            res = res + c;
            index = index + 3;
        }

        while (index < s.length()) {
            res = res + ((char) (s.charAt(index) - '1' + 'a'));
            index++;
        }
        return res;
    }

}
