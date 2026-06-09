class Solution {
    public int solution(int n) {
        if(n <= 1) return n;
        
        int answer = 1 + n;
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                answer += (i * i == n)? i : i + n / i ;
            }
        }

        return answer;
    }
}