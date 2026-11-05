import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> inMap = new HashMap<>();
        Map<String, Integer> timeMap = new TreeMap<>();
        
        for(String record : records) {
            String[] parsed = record.split(" ");
            
            String time = parsed[0];
            String car = parsed[1];
            String type = parsed[2];
            
            if(type.equals("IN")) {
                inMap.put(car, time);
            } else {
                String inTime = inMap.get(car);
                timeMap.put(car, timeMap.getOrDefault(car, 0) + diff(inTime, time));
                inMap.remove(car);
            }
        }
        
        for(Map.Entry<String, String> entry : inMap.entrySet()) {
            String car = entry.getKey();
            timeMap.put(car, timeMap.getOrDefault(car, 0) + diff(entry.getValue(), "23:59"));
        }
        
        int[] answer = new int[timeMap.size()];
        int idx = 0;
        
        for(int time : timeMap.values()) {
            if(time <= fees[0]) {
                answer[idx++] = fees[1];
            } else {
                answer[idx++] = fees[1] + (time - fees[0] + fees[2] - 1) / fees[2] * fees[3];      
            }
        }

        return answer;
    }
    
    private int diff(String start, String end) {
        return toMin(end) - toMin(start); 
    }
    
    private int toMin(String time) {
        String[] str = time.split(":");
        return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
    }
    
    
}