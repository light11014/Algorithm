import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville) {
            pq.add(s);
        }
        
        while(pq.size() > 1) {
            int first = pq.poll();
            
            if(first >= K) {
                return answer;
            }
            
            answer++;
            int second = pq.poll();
            pq.add(first + second * 2);
        }
    
        return pq.poll() < K? -1 : answer;
    }
}