import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {        
        Deque<int[]> queue = new ArrayDeque<>();
        
        for(int i = 0; i < progresses.length; i++) {
            queue.offer(new int[] {progresses[i], speeds[i]});
        }
        
        List<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()) {
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                int[] front = queue.pop();
                queue.offer(new int[] {front[0] + front[1], front[1]});
            }
            
            int count = 0;
            
            while(!queue.isEmpty() && queue.peek()[0] >= 100) {
                queue.pop();
                count++;
            }
            
            if(count > 0) list.add(count);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}