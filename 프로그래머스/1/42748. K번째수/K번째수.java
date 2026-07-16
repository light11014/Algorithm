import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < answer.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int idx = commands[i][2] - 1;
            
            List<Integer> list = new ArrayList<>();
            
            for(int s = start; s < end; s++) {
                list.add(array[s]);
            }
            
            Collections.sort(list);
            
            answer[i] = list.get(idx);
        }
        
        return answer;
    }
}