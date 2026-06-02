import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        
        int total = 0;
        for(int i = 0; i < str1.length() - 1; i++) {
            String e = str1.substring(i, i+2).toLowerCase();
            
            if('a' <= e.charAt(0) && e.charAt(0) <= 'z' && 'a' <= e.charAt(1) && e.charAt(1) <= 'z') {
                map1.put(e, map1.getOrDefault(e, 0) + 1);
                total++;
            }
                
        }
        
        for(int i = 0; i < str2.length() - 1; i++) {
            String e = str2.substring(i, i+2).toLowerCase();;
            if('a' <= e.charAt(0) && e.charAt(0) <= 'z' && 'a' <= e.charAt(1) && e.charAt(1) <= 'z') {
                map2.put(e, map2.getOrDefault(e, 0) + 1);
                total++;
            }
        }
         
        int interact = 0;
        for(String key : map1.keySet()) {
            interact += Math.min(map1.get(key), map2.getOrDefault(key, 0));
        }

        return total - interact == 0 ? 65536 : interact * 65536 / (total - interact) ;
    }
}