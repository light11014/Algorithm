class Solution {
    private static int N;
    private static int[] number;
    private static int T;
    private static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        number = numbers;
        T = target;
        
        dfs(0, 0);
        
        return answer;
    }
    
    private void dfs(int idx, int sum) {
        if(idx == N) {
            if(sum == T) answer++;
            return;
        } 
        
        dfs(idx + 1, sum + number[idx]);
        dfs(idx + 1, sum - number[idx]);
    }
}