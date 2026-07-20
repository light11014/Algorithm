import java.util.*;

class Solution {
    public int solution(int n) {
        int count = countOne(Integer.toBinaryString(n));
        
        for(int i = n + 1; ; i++) {
            if(countOne(Integer.toBinaryString(i)) == count) {
                return i;
            }
        }
    }
    
    private int countOne(String str) {
        int count = 0;
        for(char c : str.toCharArray()) {
            if(c == '1') 
                count++;
        }
        return count;
    }
}