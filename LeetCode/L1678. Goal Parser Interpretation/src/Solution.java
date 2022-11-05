public class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            Character c = command.charAt(i);
            if (c == 'G') {
                sb.append("G");
            } else {
                if (command.charAt(i + 1) == ')') {
                    sb.append("o");
                    i++;
                } else {
                    sb.append("al");
                    i = i + 3;
                }
            }
        }
        return sb.toString();
    }
}