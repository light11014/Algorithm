import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int N = id_list.length;
    
        Map<String, Integer> indexMap = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
            indexMap.put(id_list[i], i);
        }
        
        List<String>[] list = new ArrayList[N];
        
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        
        Map<String, Integer> countMap = new HashMap<>();
        
        for(String r : report) {
            String[] split = r.split(" ");
            
            String from = split[0];
            String to = split[1];
            
            int idx = indexMap.get(from);
            
            if(!list[idx].contains(to)) {
                countMap.put(to, countMap.getOrDefault(to, 0) + 1);
                list[idx].add(to);
            } 
        }
        
        int[] answer = new int[id_list.length];
        
        for(int i = 0; i < answer.length; i++) {
            int count = 0;
            
            for(String name : list[i]) {
                if(countMap.getOrDefault(name, 0) >= k) {
                    count++;
                }
            }
            
            answer[i] = count;
        }
        
        return answer;
    }
}