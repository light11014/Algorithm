import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        
        String[] sets = s.split("\\},\\{");
        
        Arrays.sort(sets, Comparator.comparingInt(a -> a.split(",").length));
        
        Set<Integer> used = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        
        for(String set : sets) {
            String[] nums = set.split(",");
            
            for(String num : nums) {
                int value = Integer.parseInt(num);
                
                if(!used.contains(value)) {
                    used.add(value);
                    result.add(value);
                }
            }
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }
}