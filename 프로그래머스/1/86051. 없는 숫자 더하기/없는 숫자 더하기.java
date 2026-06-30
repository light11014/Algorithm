import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        boolean[] num = new boolean[10];
        
        for(int number : numbers) {
            num[number] = true;
        }
        
        int answer = 0;
        for(int i = 0; i < num.length; i++) {
            if(!num[i]) {
                answer += i;
            }
        }
        
        return answer;
    }
}