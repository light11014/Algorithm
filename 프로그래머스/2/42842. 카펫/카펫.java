import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {   
        for(int h = 1; h <= Math.sqrt(yellow); h++) {
            if(yellow % h != 0) continue;
            int w = yellow / h;
            if(w + h + 2 == brown / 2) {
                return new int[]{w+2, h+2};
            }     
        }
        
        return null;
    }
}