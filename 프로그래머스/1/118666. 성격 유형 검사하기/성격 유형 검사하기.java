import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        // Map을 쓰면 좋겠다
        Map<Character, Integer> scores = new HashMap<>();
        
        // survey와 choices를 순회하면서 점수 갱신
        for(int i = 0; i < survey.length; i++) {
            int num = 4 - choices[i];
            
            if(num == 0) continue;
            else if(num > 0) {
                char c = survey[i].charAt(0);
                scores.put(c, scores.getOrDefault(c, 0) + num);
            } else {
                char c = survey[i].charAt(1);
                scores.put(c, scores.getOrDefault(c, 0) - num);
            }
        }
        
        // 마지막에 1~4번 지표까지 확인하고 성격유형 반환
        StringBuilder sb = new StringBuilder();
        sb.append(scores.getOrDefault('R', 0) >= scores.getOrDefault('T', 0)? "R" : "T");
        sb.append(scores.getOrDefault('C', 0) >= scores.getOrDefault('F', 0)? "C" : "F");
        sb.append(scores.getOrDefault('J', 0) >= scores.getOrDefault('M', 0)? "J" : "M");
        sb.append(scores.getOrDefault('A', 0) >= scores.getOrDefault('N', 0)? "A" : "N");
        
        return sb.toString();
    }
}