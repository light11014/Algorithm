import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String[] digits = String.valueOf(n).split("");
        
        Arrays.sort(digits, Collections.reverseOrder());
        
        for(int i=0; i<digits.length; i++) {
            answer *= 10;
            answer += Integer.parseInt(digits[i]);
        }
        
        
        return answer;
    }
}