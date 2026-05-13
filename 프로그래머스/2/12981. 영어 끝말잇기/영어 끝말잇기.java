import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};

        Set<String> set = new HashSet<>();
        
        int size = 0;
        char last = 0;
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            
            if(i == 0) {
                set.add(word);
                last = word.charAt(word.length() - 1);
                size++;
                continue;
            } 
            
            if(word.charAt(0) != last) {
                return new int[] {i%n+1, i/n+1};
            }
                
            set.add(word);
            last = word.charAt(word.length() - 1);
            
            if(size == set.size()) {
                return new int[] {i%n+1, i/n+1};
            }
                
            size++;
        }
        
        return new int[] {0, 0};
    }
}