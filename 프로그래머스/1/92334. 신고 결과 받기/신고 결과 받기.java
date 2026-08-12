import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int N = id_list.length;
    
        Map<String, Integer> indexMap = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
            indexMap.put(id_list[i], i);
        }
        
        Set<String>[] reported = new HashSet[N];
        
        for(int i = 0; i < N; i++) {
            reported[i] = new HashSet<>();
        }
        
        Map<String, Integer> reportCount = new HashMap<>();
        
        for(String r : report) {
            String[] split = r.split(" ");
            
            String from = split[0];
            String to = split[1];
            
            int fromIdx = indexMap.get(from);
            
            if(reported[fromIdx].add(to)) {
                reportCount.put(to, reportCount.getOrDefault(to, 0) + 1);
            } 
        }
        
        int[] answer = new int[N];
        
        for(int i = 0; i < answer.length; i++) {          
            for(String reportedUser : reported[i]) {
                if(reportCount.getOrDefault(reportedUser, 0) >= k) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}