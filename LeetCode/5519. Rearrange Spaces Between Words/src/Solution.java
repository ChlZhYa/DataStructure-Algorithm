import java.util.ArrayList;
import java.util.List;

/**
 * @author changleamazing
 * @date 2020/9/20 10:39
 **/
public class Solution {
    public String reorderSpaces(String text) {
        int spaceCount = 0;
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            } else {
                int index = text.indexOf(" ", i);
                if (index == -1) {
                    stringList.add(text.substring(i));
                } else {
                    stringList.add(text.substring(i, index));
                }
                i = index < 0 ? text.length() : index - 1;
            }
        }
        if (stringList.size() == 0) {
            return text;
        } else if (stringList.size() == 1) {
            StringBuilder sb = new StringBuilder(stringList.get(0));
            for (int i = 0; i < spaceCount; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }

        int commonSpaceCount = spaceCount / (stringList.size() - 1);
        int lastSpaceCount = spaceCount % (stringList.size() - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringList.size(); i++) {
            sb.append(stringList.get(i));
            if (i != stringList.size() - 1) {
                for (int j = 0; j < commonSpaceCount; j++) {
                    sb.append(" ");
                }
            } else {
                for (int k = 0; k < lastSpaceCount; k++) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reorderSpaces("  this   is  a sentence ");
    }
}
