import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int move : moves) {
            int index = 0;
            
            while(index < board.length && board[index][move - 1] == 0) {
                index++;
            }
            
            if(index == board.length) continue;
            
            stack.push(board[index][move - 1]);
            board[index][move - 1] = 0;
            
            if(stack.size() >= 2) {
                int first = stack.pop();
                int second = stack.pop();
                
                if(first == second) {
                    answer += 2;
                } else {
                    stack.push(second);
                    stack.push(first);
                }
            }

        }
        
        return answer;
    }
}