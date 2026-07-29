class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        
        for(int i = 0, t = 0; t < 3; t++) {
            char c = dartResult.charAt(i++);
            
            // 점수
            int score = c - '0';
            if(c == '1' && dartResult.charAt(i) == '0') {
                score = 10;
                i++;
            }
            
            // 보너스
            c = dartResult.charAt(i++);
            
            if(c == 'S') {
                scores[t] = score;
            } else if(c == 'D') {
                scores[t] = score * score;
            } else if(c == 'T') {
                scores[t] = score * score * score;
            }
            
            // 옵션
            if(i == dartResult.length()) 
                break;
            
            c = dartResult.charAt(i++);
            
            if(c == '*') {
                if(t != 0) 
                    scores[t-1] *= 2;
                scores[t] *= 2;
            } else if(c == '#') {
                scores[t] *= -1;
            } else {
                i--;
            }
        }
        
        int totalScore = 0;
        
        for(int score : scores) {
            totalScore += score;
        }
        
        return totalScore;
    }
}