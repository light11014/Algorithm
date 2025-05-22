import java.util.*;

class Solution {
    private static final int[] rx = {0, 0, 1, -1};
    private static final int[] ry = {1, -1, 0, 0};
    private static char[][] map;
    private static int N, M;
    
    private class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];
        
        Node start = null, lever = null;
        
        for(int i = 0; i < N; i++) {
            map[i] = maps[i].toCharArray();
            if(maps[i].contains("S")) {
                start = new Node(i, maps[i].indexOf("S"));
            }
            if(maps[i].contains("L")) {
                lever = new Node(i, maps[i].indexOf("L"));
            }
        }
        
        int stol = bfs(start, 'L');
        int ltoe = bfs(lever, 'E');
       
        return stol * ltoe == 0? -1 : stol + ltoe;
    }
    
    private int bfs(Node s, char e) {
        int answer = 0;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        int[][] dist = new int[map.length][map[0].length];
        
        queue.addLast(s);
        
        while(!queue.isEmpty()) {
            Node now = queue.pollFirst();
            
            for(int i=0; i<4; i++) {
                int nx = now.x + rx[i];
                int ny = now.y + ry[i];
                
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || dist[nx][ny] != 0 || map[nx][ny] == 'X') {
                    continue;
                }
                

                if(map[nx][ny] == e) {
                    return dist[now.x][now.y] + 1;
                } else {
                    queue.addLast(new Node(nx, ny));
                    dist[nx][ny] = dist[now.x][now.y] + 1;
                }
            }
            
        }
        return 0;
    }
}