import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        maps[0][0] = 1;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(0 > nx || nx >= N || 0 > ny || ny >= M || maps[nx][ny] != 1) continue;
                
                maps[nx][ny] = maps[cur[0]][cur[1]] + 1;
                
                if(nx == N - 1 && ny == M - 1)
                    return maps[nx][ny];
                
                queue.add(new int[]{nx, ny});
            }
        }

        return -1;
    }
}