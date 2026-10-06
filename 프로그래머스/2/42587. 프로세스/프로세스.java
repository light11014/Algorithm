import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
            queue.offer(i);
        }
        
        int answer = 1;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            if(priorities[cur] == pq.peek()) {
                pq.poll(); 
                
                if(cur == location) {
                    return answer;
                }
                
                answer++;
            } else {
                queue.offer(cur);
            }
        }
        
        return -1;
    }
}