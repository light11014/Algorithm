import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < 26; i++) {
            map.put(Character.toString('A' + i), i + 1);
        }
        
        for(int start = 0; start < msg.length(); start++) {
            String word = msg.substring(start, start + 1);
            for(int end = start + 1; end <= msg.length(); end++) {
                if(map.containsKey(msg.substring(start, end))) {
                    word = msg.substring(start, end);
                } else {
                    break;
                }
            }
            
            answer.add(map.get(word));
            
            if(start + word.length() < msg.length()) {
                map.put(msg.substring(start, start + word.length() + 1), map.size() + 1);
            }
            
            if(word.length() > 1)
                start += word.length() - 1;
        }
        
        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}