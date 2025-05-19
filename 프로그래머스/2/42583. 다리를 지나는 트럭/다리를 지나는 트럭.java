import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int cur_weight = 0;
        
        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        
        int i = 0;
        while(i < truck_weights.length) {
            if(bridge.size() == bridge_length) {
                cur_weight -= bridge.poll();
            }
            
            if(cur_weight + truck_weights[i] <= weight) {
                bridge.add(truck_weights[i]);
                cur_weight += truck_weights[i];
                i++;
            } else {
                bridge.add(0);
            }
            answer++;
        }
        
        return answer + bridge_length;
    }
}