import java.util.*;

class Solution {
    public int solution(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        String twice = s + s;
        int result = 0;
            
        A: for(int i = 0 ; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>(); 
            for(int n = i; n < i + s.length(); n++) {
                char c = twice.charAt(n);
                if(!map.containsKey(c)) {
                    stack.push(c);
                } else {
                    if(stack.isEmpty() || stack.pop() != map.get(c)) {
                        continue A;
                    }
                }
            }
            if(stack.isEmpty()) {
                result++;
            }
        }
        
        return result;
    }
}