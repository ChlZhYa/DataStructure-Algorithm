package L1704;

class Solution {
    public boolean halvesAreAlike(String s) {
        String h = "aeiouAEIOU";
        int l1 = 0, l2 = s.length() / 2;
        int cnt1 = 0,cnt2 = 0;
        for(int i = 0;i < l2;i++){
            if(h.indexOf(s.charAt(i)) >= 0){
                cnt1++;
            }
        }
        for(int i = l2;i < s.length();i++){
            if(h.indexOf(s.charAt(i)) >= 0){
                cnt2++;
            }
        }
        return cnt1 == cnt2;
    }
}