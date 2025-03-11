import java.util.*;

class Solution {
    public int[] solution(long n) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        long l = n;
        while(l > 0) {
            answer.add((int)(l%10));
            l /= 10L;
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}