import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder out = new StringBuilder();
        boolean start = true;
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch == ' ') {
                start = true;
                out.append(ch);
            } else {
                if(start) {
                    out.append(Character.toUpperCase(ch));
                } else {
                    out.append(Character.toLowerCase(ch));
                }
                start = false;
            }
        }
        
        return out.toString();
    }
}