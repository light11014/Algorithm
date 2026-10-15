class Solution {
    public long solution(int[] arr) {
        long answer = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }
    
    public long lcm(long a, long b) {
        return a * b / gcd(a, b);
    } 
    
    public long gcd(long a, long b) {
        return b == 0? a : gcd(b, a % b);
    }
}