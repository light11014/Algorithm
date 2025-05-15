import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 1. 각 작업의 배포 가능일 계산
        int[] leftDays = new int[progresses.length];
        for(int i = 0; i < leftDays.length; i++) {
            leftDays[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        // 2. 배포될 작업 수
        int count = 0;
        int maxDay = leftDays[0]; // 가장 늦게 배포되는 날
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < leftDays.length; i++) {
            if(leftDays[i] <= maxDay) { // 배포 예정일이 기준 배포일보다 빠름. 먼저 완료됨.
                count++;
            } else { // 배포 예정일이 기준 배포일보다 느림.
                answer.add(count);
                count = 1;
                maxDay = leftDays[i];
            }
        }
        
        answer.add(count);
        return answer.stream().mapToInt(i->i).toArray();
    }
}