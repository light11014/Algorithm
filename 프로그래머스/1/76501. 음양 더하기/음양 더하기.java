class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int N = absolutes.length;
        
        for(int i = 0; i < N; i++) {
            answer += (signs[i]? 1 : -1) * absolutes[i];
        }
        
        return answer;
    }
}