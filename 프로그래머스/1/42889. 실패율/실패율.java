import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] failed = new int [N + 2];
        
        for(int stage : stages) {
            failed[stage]++;
        }
        
        double[] failureRates = new double[N + 1];
        int players = stages.length;
        
        for(int stage = 1; stage <= N; stage++) {
            if(players == 0) {
                failureRates[stage] = 0;
            } else{
                failureRates[stage] = (double) failed[stage] / players;
            }
            
            players -= failed[stage];
        }
        
        Integer[] stageNumbers = new Integer[N];
        
        for (int i = 0; i < N; i++) {
            stageNumbers[i] = i + 1;
        }
        
        Arrays.sort(stageNumbers, (a, b) -> {
            int compare = Double.compare(
                    failureRates[b],
                    failureRates[a]
            );

            if (compare != 0) {
                return compare;
            }

            return Integer.compare(a, b);
        });
        
        return Arrays.stream(stageNumbers)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}