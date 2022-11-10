package L0784;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        res.add("");
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)){
                res = res.stream().map(o -> {
                    List<String> list = new ArrayList<>();
                    list.add(o + Character.toLowerCase(c));
                    list.add(o + Character.toUpperCase(c));
                    return list;
                }).flatMap(List::stream).collect(Collectors.toList());
            }else{
                res = res.stream().map(o -> o + c).collect(Collectors.toList());
            }
        }
        return res;
    }
}