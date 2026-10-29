import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Deque<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0; i < prices.length; i++) {
            int curPrice = prices[i];
            
            int n = queue.size();
            for(int j = 0; j < n; j++) {
                int idx = queue.poll();
                
                if(curPrice < prices[idx]) {
                    answer[idx] = i - idx;
                } else {
                    queue.add(idx);
                }
            }
            
            queue.add(i);  
        }
        
        while(!queue.isEmpty()) {
            int idx = queue.poll();
            answer[idx] = prices.length - 1 - idx;
        }
    
        return answer;
    }
}