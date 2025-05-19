import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i = 0; i <= discount.length-10; i++) {
            HashMap<String, Integer> map = refreshMap(want, number);
            for(int j = 0; j < 10; j++) {
                if(map.getOrDefault(discount[i+j], 0) == 0) {
                    break;
                } else {
                    if(j == 9) answer++;
                    map.put(discount[i+j], map.get(discount[i+j])-1);
                }
            }
        }
        
        return answer;
    }
    
    private HashMap<String, Integer> refreshMap(String[] want, int[] number) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i< want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        return map;
    }
}