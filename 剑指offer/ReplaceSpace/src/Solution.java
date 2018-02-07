/**
 * User: Changle
 * Date: 2017-12-26 17:02
 * Description:
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 时间限制：1秒 空间限制：32768K
 */

public class Solution {

    private static String replace(StringBuffer str) {
        String s = str.toString();
        char[] strChar = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strChar.length; i++) {
            if (strChar[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(strChar[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] a = "a ".split(" ");
        System.out.println(a.length);
        StringBuffer sb = new StringBuffer("We Are Happy");
        System.out.println(replace(sb));
    }
}
