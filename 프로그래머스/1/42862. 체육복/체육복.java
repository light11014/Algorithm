import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] students = new boolean[n + 1];
        Arrays.fill(students, true);
        
        for(int i : lost) {
            students[i] = false;
        }
        
        Arrays.sort(reserve);
        for(int i = 0; i < reserve.length; i++) {
            if(!students[reserve[i]]) {
                students[reserve[i]] = true;
                reserve[i] = -1;
            }
        }
        
        for(int i = 0; i < reserve.length; i++) {
            if(reserve[i] - 1 >= 1 && !students[reserve[i] - 1]) {
                students[reserve[i] - 1] = true;
            } else if(reserve[i] + 1 <= n && !students[reserve[i] + 1]) {
                students[reserve[i] + 1] = true;
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(students[i]) {
                answer++;
            }
        }
        return answer;
    }
}