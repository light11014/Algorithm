import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = name.length() - 1;
        
        for(int i = 1 ; i < name.length(); i++) {
            if(name.charAt(i) == 'A') {
                int left = i-1;
                while(i < name.length() && name.charAt(i) == 'A')
                    i++;
                int right = name.length() - i;
                
                answer = Math.min(answer, 2 * left + right);
                answer = Math.min(answer, left + 2 * right);
            }
        }
        
        for(char c : name.toCharArray()) {
            answer += Math.min(c-'A', 'Z' - c + 1);
        }
        
        return answer;
    }
}