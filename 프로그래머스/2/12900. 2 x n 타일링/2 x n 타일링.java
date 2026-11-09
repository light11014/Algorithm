class Solution {
    public int solution(int n) {
        if (n == 1) return 1;

        long prev2 = 1;
        long prev1 = 2;
        
        for(int i = 3; i <= n; i++) {
            long cur = (prev1 + prev2) % 1_000_000_007;
            prev2 = prev1;
            prev1 = cur;
        }
        
        return (int) prev1;
    }
}