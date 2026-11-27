class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0;
        int right = 1;
        int sum = sequence[0];
        int minLength = Integer.MAX_VALUE;
        
        while(left < sequence.length) {
            if(sum == k && right - left < minLength) {
                answer[0] = left;
                answer[1] = right - 1;
                minLength = right - left;
            } 
                        
            if(sum >= k) {
                sum -= sequence[left];
                left++;
            } else {
                if(right == sequence.length) break;
                
                sum += sequence[right];
                right++;
            }
        }
             
        return answer; 
    }
}