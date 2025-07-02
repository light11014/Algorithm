import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String f = "%"+n+"s";
        
        for(int i = 0; i < n; i++) {
            int result = arr1[i] | arr2[i];
            String binaryStr = Integer.toBinaryString(result);
            answer[i] = String.format(f, binaryStr).replace("1", "#").replace("0", " ");
        }
        
        return answer;
    }
}