import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int N = arr.length;
        
        if(N == 1) {
            return new int[] {-1};
        }
        
        List<Integer> list = new ArrayList<>();
        
        int min = Integer.MAX_VALUE;
        
        for(int num : arr) {
            min = Math.min(min, num);
        }

        for(int num : arr) {
            if(min != num)
                list.add(num);
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}