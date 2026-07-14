import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        
        for(int num : arr) {
            if(list.isEmpty() || list.get(list.size() - 1) != num) {
                list.add(num);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}