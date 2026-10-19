class Solution {
    static int answer, N;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        N = dungeons.length;
        boolean[] visited = new boolean[N];
        
        dfs(dungeons, visited, k, 0);
        
        return answer;
    }
    
    private void dfs(int[][] dungeons, boolean[] visited, int left, int count) {
        answer = Math.max(answer, count);
        
        for(int i = 0; i < N; i++) {
            if(!visited[i] && left >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dungeons, visited, left - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
}