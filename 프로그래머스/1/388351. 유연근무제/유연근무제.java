class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int ee = 0; ee < schedules.length; ee++) {
            int score = 0;
            
            for(int day = 0; day < 7; day++) {
                if((startday + day) % 7 == 6 
                   || (startday + day) % 7 == 0) continue;
                
                if(inTime(timelogs[ee][day], schedules[ee])) {
                    score++;
                } else {
                    break;
                }
            }
            
            if(score == 5) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean inTime(int time, int schedule) {
        int min = schedule / 100 * 60 + schedule % 100;
        int target = time / 100 * 60 + time % 100;

        return target <= min + 10;
    }
}