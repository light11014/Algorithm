import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int tang : tangerine) {
            map.put(tang, map.getOrDefault(tang, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Comparator.reverseOrder());
        
        int answer = 0;

        for (int count : counts) {
            k -= count;
            answer++;

            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}