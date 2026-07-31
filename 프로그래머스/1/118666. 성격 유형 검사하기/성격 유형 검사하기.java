import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> scores = new HashMap<>();
        
        for(int i = 0; i < survey.length; i++) {
            int score = Math.abs(choices[i] - 4);

            if (choices[i] < 4) {
                char type = survey[i].charAt(0);
                scores.put(type, scores.getOrDefault(type, 0) + score);
            } else if (choices[i] > 4) {
                char type = survey[i].charAt(1);
                scores.put(type, scores.getOrDefault(type, 0) + score);
            }
        }
        
        StringBuilder answer = new StringBuilder();

        answer.append(getType(scores, 'R', 'T'));
        answer.append(getType(scores, 'C', 'F'));
        answer.append(getType(scores, 'J', 'M'));
        answer.append(getType(scores, 'A', 'N'));

        return answer.toString();
    }
    
    private char getType(Map<Character, Integer> scores, char first, char second) {
        int firstScore = scores.getOrDefault(first, 0);
        int secondScore = scores.getOrDefault(second, 0);

        return firstScore >= secondScore? first : second;
    }
}