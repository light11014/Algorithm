import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        for(int i = 0; i < numbers.length; i++) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int idx = stack.pop();
                answer[idx] = numbers[i];
            }
            
            stack.push(i);
        }

        return answer;
    }
}