import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Deque<Integer> stack = new ArrayDeque<>();
    
        for(int i = 0; i < prices.length; i++) {
            int curPrice = prices[i];
            
            while (!stack.isEmpty()
                    && prices[stack.peek()] > curPrice) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }

            stack.push(i);  
        }
        
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - 1 - idx;
        }
    
        return answer;
    }
}