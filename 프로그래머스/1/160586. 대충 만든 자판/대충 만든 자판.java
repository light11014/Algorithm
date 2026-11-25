import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] minPress = new int[26];
        
        Arrays.fill(minPress, Integer.MAX_VALUE);
        
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                int idx = key.charAt(i) - 'A';
                minPress[idx] = Math.min(minPress[idx], i + 1);
            }
        }
        
        int[] answer = new int[targets.length];
        
        for(int i = 0; i < targets.length; i++) {
            for(char c : targets[i].toCharArray()) {              
                if(minPress[c - 'A'] == Integer.MAX_VALUE) {
                    answer[i] = -1;
                    break;
                } 
                
                answer[i] += minPress[c - 'A'];
            }
        }
        
        return answer;
    }
}
