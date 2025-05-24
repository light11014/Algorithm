import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i = 0; i < answer.length; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            
            int cnt = 0;
            for(char c : s[i].toCharArray()) {
                stack.push(c);
                if(stack.size() >= 3) {
                    char c3 = stack.pop();
                    char c2 = stack.pop();
                    char c1 = stack.pop();
                    if((""+c1+c2+c3).equals("110")) {
                        cnt++;
                    } else {
                        stack.push(c1);
                        stack.push(c2);
                        stack.push(c3);
                    }
                }
            }
            
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()) {
                sb.append(stack.pollLast());
            }
            sb.insert(sb.lastIndexOf("0") + 1, "110".repeat(cnt));
            
            answer[i] = sb.toString();
        }
        return answer;
    }
}