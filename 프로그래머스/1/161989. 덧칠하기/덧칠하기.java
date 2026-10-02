class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int end = 0;
        
        for(int cur : section) {
            if(end < cur) {
                answer++;
                end = cur + m - 1;
            }
        }
        
        return answer;
    }
}