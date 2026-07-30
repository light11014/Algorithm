import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int[] burger = {1, 3, 2, 1};
        int answer = 0;
        
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i : ingredient) {
            stack.push(i);
            
            while(stack.size() >= 4) {
                boolean match = true;
                
                for(int j = 0; j < 4; j++) {
                    if(stack.peek() == burger[j]) {
                        stack.pop();
                    } else {
                        for(int k = j - 1; k >= 0; k--) {
                            stack.push(burger[k]);
                        }
                        match = false;
                        break;
                    }
                }
                
                if(match) {
                    answer++;
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}