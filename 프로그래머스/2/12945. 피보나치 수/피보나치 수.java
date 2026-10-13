class Solution {
    public int solution(int n) {
        int prev2 = 1;
        int prev1 = 1;
        
        for(int i = 3; i <= n; i++) {
            int cur = (prev1 + prev2) % 1234567;
            prev2 = prev1;
            prev1 = cur;
        }
        
        return prev1;
    }
}