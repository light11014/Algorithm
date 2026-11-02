import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        int answer = 0;
        int num = 1;
        for(int box : order) {
            while(num < box) {
                stack.push(num++);
            }
            
            if(num == box) {
                answer++;
                num++;
            } else if(!stack.isEmpty() && stack.peek() == box) {
                answer++;
                stack.pop();
            } else {
                break;
            }
        }
        
        return answer;
    }
}