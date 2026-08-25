import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {       
        int N = friends.length;
        
        Map<String, Integer> idxMap = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
            idxMap.put(friends[i], i);
        }
        
        int[] score = new int[N];
        int[][] record = new int[N][N];
        
        for(String gift : gifts) {
            String[] split = gift.split(" ");
            
            int from = idxMap.get(split[0]);
            int to = idxMap.get(split[1]);
            
            record[from][to]++;
            
            score[from]++;
            score[to]--;
        }
        
        int[] count = new int[N];
        
        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                int a = record[i][j];
                int b = record[j][i];
                
                if(a > b) {
                    count[i]++;
                } else if(a < b) {
                    count[j]++;
                } else if(score[i] > score[j]) {
                    count[i]++;
                } else if(score[i] < score[j]) {
                    count[j]++;
                }
            }
        }
        
        Arrays.sort(count);
        
        return count[N-1];
    }
}