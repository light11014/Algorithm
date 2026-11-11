import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nickname = new HashMap<>();
        
        for(String s : record) {
            String[] parsed = s.split(" ");
            
            if(parsed[0].equals("Enter") || 
               parsed[0].equals("Change") ) {
                nickname.put(parsed[1], parsed[2]);
            }
        }
        
        List<String> answer = new ArrayList<>();
        
        for(String s : record) {
            String[] parsed = s.split(" ");
            
            if(parsed[0].equals("Enter")) {
                answer.add(nickname.get(parsed[1]) + "님이 들어왔습니다.");
            } else if(parsed[0].equals("Leave")) {
                answer.add(nickname.get(parsed[1]) + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[0]);
    }
}