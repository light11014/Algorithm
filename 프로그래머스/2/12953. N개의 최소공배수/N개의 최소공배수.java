class Solution {
    public long solution(int[] arr) {
        int answer = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            answer = LCM(answer, arr[i]);
        }
        
        return answer;
    }
    
    public int LCM(int a, int b) {
        return a * b / GCD(a, b);
    } 
    
    public int GCD(int a, int b) {
        return b == 0? a : GCD(b, a % b);
    }
}