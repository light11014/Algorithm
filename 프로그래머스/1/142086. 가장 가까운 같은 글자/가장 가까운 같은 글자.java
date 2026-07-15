import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        
        int N = s.length();
        int[] answer = new int[N];
        
        for(int i = 0; i < N; i++) {
            char c = s.charAt(i);
            answer[i] = idx[c - 'a'] == -1? -1 : i - idx[c - 'a'];
            idx[c - 'a'] = i;
        }

        return answer;
    }
}