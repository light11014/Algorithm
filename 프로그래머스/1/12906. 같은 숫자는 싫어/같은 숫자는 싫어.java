import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        
        int pre = -1;
        for(int num : arr) {
            if(list.isEmpty() || pre != num) {
                pre = num;
                list.add(num);
            } 
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}