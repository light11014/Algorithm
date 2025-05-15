import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++) {
            deque.addLast(i);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        while(!deque.isEmpty()) {
            int i = deque.pollFirst();
            int released = 1;
            int days = (100 - progresses[i]) % speeds[i] == 0? (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] + 1;
            
            while(!deque.isEmpty()) {
                int next = deque.pollFirst();
                if(progresses[next] + speeds[next] * days >= 100) {
                    released++;
                } else {
                    deque.addFirst(next);
                    break;
                }
            }
            
            result.add(released);
        }
        
        
        return result.stream().mapToInt(i->i).toArray();
    }
}