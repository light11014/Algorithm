class Solution {
    boolean solution(String s) {
        int open = 0;
        
        for(char c : s.toCharArray()) {
            if(c == '(') {
                open++;
            } else if(c == ')' && open > 0) {
                open--;
            } else {
                return false;
            }
        }

        return open == 0;
    }
}