import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        
        for(int i = 1; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // 가격이 떨어짐
                int j = stack.pop();
                answer[j] = i - j;
            }
            
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = prices.length - 1 - j;
        }
        
        return answer;
    }
}