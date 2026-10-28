import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
       
        
        List<Character> list = new ArrayList<>();
        
        for(int num = 0; list.size() < t * m; num++) {
            String str = Integer.toString(num, n).toUpperCase();
            
            for(char c : str.toCharArray()) {
                list.add(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = p - 1; i < list.size() && sb.length() < t; i += m) {
            sb.append(list.get(i));
        }
        
        return sb.toString();
    }
}