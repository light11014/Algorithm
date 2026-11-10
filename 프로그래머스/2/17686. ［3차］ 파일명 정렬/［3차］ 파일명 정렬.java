import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (a, b) -> {
            String[] parsedA = parse(a);
            String[] parsedB = parse(b);
           
            if(!parsedA[0].equals(parsedB[0])) {
               return parsedA[0].compareTo(parsedB[0]);
            } 
            
            int numberA = Integer.parseInt(parsedA[1]);
            int numberB = Integer.parseInt(parsedB[1]);
            
            return Integer.compare(numberA, numberB);
        });
        
        return files;
    }
    
    private String[] parse(String str) {
        String[] result = new String[3];
        
        int end = 0;
        while(end < str.length() && !Character.isDigit(str.charAt(end))) {
            end++;
        }
        
        result[0] = end == 0? "" : str.substring(0, end).toLowerCase();
        
        int start = end;
        while(end < str.length() && Character.isDigit(str.charAt(end))) {
            end++;
        }
        
        result[1] = start == end ? "" : str.substring(start, end);
        result[2] = end == str.length()? "" : str.substring(end, str.length());
        
        return result;
    }
}