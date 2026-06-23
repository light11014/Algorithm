class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int end = Math.max(a, b);
        int start = Math.min(a, b);
        for(int i = start; i <= end; i++) {
            answer += i;
        }
        return answer;
    }
}