import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> countMap = new HashMap<>();
        
        for(int i = 0; i < 10; i++) {
            countMap.put(discount[i], countMap.getOrDefault(discount[i], 0) + 1);
        }
        
        int answer = 0;
        
        if(isMatch(want, number, countMap)) {
            answer++;
        }
        
        for(int s = 0; s < discount.length - 10; s++) {
            String out = discount[s];
            String in = discount[s + 10];
            
            countMap.put(out , countMap.get(out) - 1);
            
            if(countMap.get(out) == 0) {
                countMap.remove(out);
            }
            
            countMap.put(in, countMap.getOrDefault(in, 0) + 1);
            
            if(isMatch(want, number, countMap)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isMatch(String[] want, int[] number, Map<String, Integer> countMap) {
        for(int i = 0; i < want.length; i++) {
            if(countMap.getOrDefault(want[i], 0) != number[i])
                return false;
        }
        
        return true;
    }
}