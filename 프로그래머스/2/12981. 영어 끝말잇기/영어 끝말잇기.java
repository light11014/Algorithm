import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();
        
        used.add(words[0]);
        
        for(int i = 1; i < words.length; i++) {
            String pre = words[i - 1];
            String cur = words[i];
            
            boolean wrongStart = pre.charAt(pre.length() - 1) != cur.charAt(0);
            boolean duplicated = !used.add(cur);
            
            if(wrongStart || duplicated) {
                return new int[] {i % n + 1, i / n + 1};
            }
        }
        
        return new int[] {0, 0};
    }
}