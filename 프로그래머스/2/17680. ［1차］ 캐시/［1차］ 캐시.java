import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        
        int answer = 0;
        
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        
        for(String city : cities) {
            String c = city.toUpperCase();
            
            if(set.contains(c)) {
                answer++;     // 캐시 히트  
                
                queue.remove(c);
                queue.add(c);
            } else {
                answer += 5;  // 캐시 미스
                
                if(queue.size() == cacheSize) {
                    set.remove(queue.poll());
                }
                queue.add(c);
                set.add(c);
            }
        }
        
        return answer;
    }
}