import java.util.*;

class Solution {
    Map<String, Integer> wantMap = new HashMap<>();
    Map<String, Integer> countMap = new HashMap<>();
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for(int i = 0; i < 10; i++) {
            countMap.put(discount[i], countMap.getOrDefault(discount[i], 0) + 1);
        }
        
        if(equalsMaps(want)) {
            answer++;
        }
        
        for(int s = 0; s < discount.length - 10; s++) {
            countMap.put(discount[s], countMap.get(discount[s]) - 1);
            countMap.put(discount[s + 10], countMap.getOrDefault(discount[s + 10], 0) + 1);
            
            if(equalsMaps(want)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean equalsMaps(String[] want) {
        for(int i = 0; i < want.length; i++) {
            int w = wantMap.getOrDefault(want[i], 0);
            int c = countMap.getOrDefault(want[i], 0);
            
            if(w != c) {
                return false;
            }
        }
        return true;
    }
}