import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int min = 0;
        int max = 0;
        
        Set<Integer> set = new HashSet<>();
        for(int num : win_nums) {
            set.add(num);
        }
        
        for(int num : lottos) {
            if(num == 0) 
                max++;
            else if(set.contains(num)) {
                min++;
                max++;
            }
        }

        return new int[] {(max < 2)? 6 : 7 - max, (min < 2)? 6 : 7 - min};
    }
}