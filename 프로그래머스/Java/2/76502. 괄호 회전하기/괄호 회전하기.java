import java.util.*;

class Solution {
    public int solution(String s) {
        Map<Character, Character> map = new HashMap<>();
        
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        
        char[] arr = s.toCharArray();
        
        int answer = 0;
        
        for(int start = 0; start < arr.length; start++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            
            boolean valid = true;
            for(int j = start; j < start + arr.length; j++) {
                char c = arr[j % arr.length];
                
                if(c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else if(!stack.isEmpty()) {
                    char p = stack.pop();
                    
                    if(map.get(c) != p) {
                        valid = false;
                        break;
                    }
                } else {
                    valid = false;
                    break;
                }
            }
            
            if(valid && stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}