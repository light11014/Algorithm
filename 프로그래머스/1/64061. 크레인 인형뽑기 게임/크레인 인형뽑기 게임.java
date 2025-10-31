import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(int move : moves) {
            int idx = move - 1;
            
            for(int i = 0; i < board.length; i++) {
                if(board[i][idx] == 0)
                    continue;
                else {
                    int doll = board[i][idx];
                    board[i][idx] = 0;
                    if(!stack.isEmpty()) {
                        if(stack.peek() == doll) {
                            stack.pop();
                            answer += 2;
                            break;
                        }
                    }
                    stack.push(doll);
                    break;
                }
            }
        }
        
        
        return answer;
    }
}