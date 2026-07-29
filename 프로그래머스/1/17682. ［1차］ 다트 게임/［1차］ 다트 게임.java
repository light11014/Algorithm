class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int index = 0;
        
        for(int turn = 0; turn < 3; turn++) {
            // 점수
            int score;
            if(dartResult.charAt(index) == '1' 
               && dartResult.charAt(index + 1) == '0') {
                score = 10;
                index += 2;
            } else {
                score = dartResult.charAt(index) - '0';
                index++;
            }
            
            // 보너스
            char bonus = dartResult.charAt(index++);
            
            if(bonus == 'S') {
                scores[turn] = score;
            } else if(bonus == 'D') {
                scores[turn] = score * score;
            } else if(bonus == 'T') {
                scores[turn] = score * score * score;
            }
            
            // 옵션
            if(index < dartResult.length()) {
                char option = dartResult.charAt(index);
                
                if(option == '*') {
                    scores[turn] *= 2;
                    
                    if(turn > 0) 
                        scores[turn - 1] *= 2;
                    
                    index++;
                } else if(option == '#') {
                    scores[turn] *= -1;
                    index++;
                } 
            }
        }

        return scores[0] + scores[1] + scores[2];
    }
}