import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (a, b) -> {
            String[] parsedA = parse(a);
            String[] parsedB = parse(b);
            
            int headCompare = parsedA[0].compareTo(parsedB[0]);
            
            if(headCompare != 0) {
               return headCompare;
            } 
            
            int numberA = Integer.parseInt(parsedA[1]);
            int numberB = Integer.parseInt(parsedB[1]);
            
            return Integer.compare(numberA, numberB);
        });
        
        return files;
    }
    
    private String[] parse(String str) {
        int numberStart = 0;
        while(numberStart < str.length() 
              && !Character.isDigit(str.charAt(numberStart))) {
            numberStart++;
        }
        
        int numberEnd = numberStart;
        
        while(numberEnd < str.length() && Character.isDigit(str.charAt(numberEnd))) {
            numberEnd++;
        }
        
        String head = str.substring(0, numberStart).toLowerCase();
        String number = str.substring(numberStart, numberEnd);
        
        return new String[] {head, number};
    }
}