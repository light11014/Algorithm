import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int tang : tangerine) {
            map.put(tang, map.getOrDefault(tang, 0) + 1);
        }
        
        List<Integer> count = new ArrayList<>(map.values());
        count.sort(Comparator.reverseOrder());
        
        int answer = 0;
        
        while(k > 0) {
            k -= count.get(answer++);
        }
        
        return answer;
    }
}