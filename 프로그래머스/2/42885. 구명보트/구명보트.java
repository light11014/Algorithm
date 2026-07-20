import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int answer = 0;
        for(int s = 0, e = people.length - 1; s <= e; e--) {
            int left = limit;
            
            left -= people[e];
            
            if(left >= people[s]) {
                s++;
            }
            answer++;
        }
        
        return answer;
    }
}