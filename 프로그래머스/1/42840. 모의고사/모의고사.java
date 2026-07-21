import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] pattern = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] collect = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            for(int j = 0; j < 3; j++) {
                if(pattern[j][i % pattern[j].length] == answers[i]) {
                    collect[j]++;
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        int max = Math.max(collect[0], Math.max(collect[1], collect[2]));
        
        for(int i = 0; i < collect.length; i++) {
            if(collect[i] == max) {
                list.add(i + 1);
            }
        }
        
        return list.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}