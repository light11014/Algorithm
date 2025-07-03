import java.util.*;

class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder(convert(n)); 
        return Integer.parseInt(sb.reverse().toString(), 3);
    }
    
    private String convert(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            sb.insert(0, n % 3);
            n /= 3;
        }
        
        return sb.toString();
    }
}