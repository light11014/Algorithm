import java.util.*;

class Solution {
    private static int[] rx = {0, 0, 1, -1};
    private static int[] ry = {1, -1, 0, 0};
    
    private static class Node {
        int r;
        int c;
        
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(String[] maps) {
        
        // 시작(S) -> 레버(L)
        int r1 = bfs('S', 'L', maps);
        
        if(r1 == -1) 
            return -1;
        
        // 레버(L) -> 출구(E)
        int r2 = bfs('L', 'E', maps);
        return (r2 == -1)? -1 : r1 + r2;
    }
    
    private int bfs(char start, char end, String[] maps) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        
        int N = maps.length;
        int M = maps[0].length();
        
        int[][] dist = new int[N][M];
        
        // 시작 위치 찾기
        for(int i = 0; i < N; i++) {
            int j = maps[i].indexOf(start);
            if(j != -1) {
                queue.addLast(new Node(i, j));
                dist[i][j] = 1;
            }
        }
        
        while(!queue.isEmpty()) {
            Node now = queue.pollFirst();
            
            for(int i = 0; i < rx.length; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];
                
                if(nr < 0 || nc < 0 || nr >= N || nc >= M)
                    continue;
                
                if(maps[nr].charAt(nc) == 'X')
                    continue;
                
                if(dist[nr][nc] == 0) {
                    queue.addLast(new Node(nr, nc));
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
                
                if(maps[nr].charAt(nc) == end) {
                    return dist[nr][nc] - 1;
                }
            }
        }
        
        return -1;     
    }
}