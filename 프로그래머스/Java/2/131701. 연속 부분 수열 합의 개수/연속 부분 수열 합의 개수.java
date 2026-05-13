import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        int[] doubledElements = new int[2 * elements.length];
        
        for(int i = 0; i < elements.length; i++) {
            doubledElements[i] = elements[i];
            doubledElements[i + elements.length] = elements[i];
        }
        
        for(int start = 0; start < elements.length; start++) {
            int sum = 0;
            for(int count = 0; count < elements.length; count++) {
                sum += doubledElements[start + count];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}