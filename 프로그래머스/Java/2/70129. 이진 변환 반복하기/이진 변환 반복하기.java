import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        
        String str = s;
        while(!str.equals("1")) {
            int one = 0;
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c == '0') {
                    answer[1]++;
                } else {
                    one++;
                }
            }

            str = Integer.toBinaryString(one);
            answer[0]++;
        }
        
        return answer;
    }
}