import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] periods = new int[26];
        
        for(String term : terms) {
            char type = term.charAt(0);
            int month = Integer.parseInt(term.split(" ")[1]);
            
            periods[type - 'A'] = month; 
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < privacies.length; i++) {
            String[] parsed = privacies[i].split(" ");
            String[] parsedDate = parsed[0].split("\\.");
            int period = periods[parsed[1].charAt(0) - 'A'];
            
            int year = Integer.parseInt(parsedDate[0]);
            int month = Integer.parseInt(parsedDate[1]);
            int day = Integer.parseInt(parsedDate[2]);
            
            month += period;
            
            if(month > 12) {
                if(month % 12 == 0) {
                    year += month / 12 - 1;
                    month = 12;
                } else {
                    year += month / 12;
                    month = month % 12;
                }
            }
            
            if(today.compareTo(String.format("%d.%02d.%02d", year, month, day)) >= 0) {
                list.add(i+1);
            }
        }        
        
        return list.stream().mapToInt(Integer::intValue).toArray(); 
    }
}