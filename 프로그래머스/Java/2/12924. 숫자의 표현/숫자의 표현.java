class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for(int i = 1; i <= n / 2; i++) {
            int sum = n;
            
            for(int j = i; j <= n; j++) {
                if(sum > 0) {
                    sum -= j;
                } else {
                    break;
                }
            }
            
            if(sum == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}