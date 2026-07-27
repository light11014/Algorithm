class Solution {
    public int solution(String s) {
        int answer = 0;
        int count = 0;
        char target = 0;
        
        for(char c : s.toCharArray()) {
            if(target == 0) {
                target = c;
                count = 1;
                continue;
            }
            
            if(target == c) {
                count++;
            } else {
                count--;
            }
            
            if(count == 0) {
                target = 0;
                count = 0;
                answer++;
            }
        }
        
        return count == 0? answer : answer + 1;
    }
}