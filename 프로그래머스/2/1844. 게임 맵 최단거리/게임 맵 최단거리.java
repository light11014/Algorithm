import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;
    static int[][] dist;
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        
        dist = new int[N][M];
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        dist[0][0] = 1;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(!isRange(nx, ny) || maps[nx][ny] == 0 
                        || dist[nx][ny] != 0) continue;
                
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                
                if(nx == N - 1 && ny == M - 1)
                    return dist[nx][ny];
                
                
                queue.add(new int[]{nx, ny});
            }
        }

        return -1;
    }
    
    static private boolean isRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}