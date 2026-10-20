import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        
        boolean[][] visited = new boolean[N][M];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            if (x == N - 1 && y == M - 1) {
                return dist;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(0 > nx || nx >= N || 0 > ny || ny >= M) continue;
                if(maps[nx][ny] == 0 || visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, dist + 1});
            }
        }

        return -1;
    }
}