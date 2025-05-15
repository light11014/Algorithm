import java.util.*; 

class Solution
{
    public int solution(String s)
    {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(char c : s.toCharArray()) {
            if(stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        
        return stack.isEmpty()? 1 : 0;
    }
}