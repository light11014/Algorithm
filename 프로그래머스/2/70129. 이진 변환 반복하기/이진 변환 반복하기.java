import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")) {
            String temp = s.replace("0", "");
            answer[1] += s.length() - temp.length();
            s = Integer.toBinaryString(temp.length());
            answer[0]++;
        }
        
        return answer;
    }
}