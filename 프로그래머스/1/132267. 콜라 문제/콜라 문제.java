class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a) {
            int newBottle = b * (n / a);
            n = newBottle + n % a;
            answer += newBottle;
        }
        
        return answer;
    }
}