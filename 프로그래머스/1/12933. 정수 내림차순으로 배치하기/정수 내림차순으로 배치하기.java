import java.util.*;

class Solution {
    public long solution(long n) {
        List<Integer> list = new ArrayList<>();
        
        while(n > 0) {
            list.add((int)(n % 10));
            n /= 10;
        }
        
        list.sort((a, b) -> a - b);
        
        long answer = 0;
        
        for(int i = list.size() - 1; i >= 0; i--) {
            answer += list.get(i);
            
            if(i != 0)
                answer *= 10;
        }
        
        return answer;
    }
}