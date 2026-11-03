import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if(x == y) return 0;
        
        boolean[] visited = new boolean[y + 1];
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, 0});
        visited[x] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int dist = cur[1];
            
            if(pos == y) {
                return dist;
            }
            
            if(pos + n <= y && !visited[pos + n]) {
                queue.offer(new int[]{pos + n, dist + 1});
                visited[pos + n] = true;
            }
            
            if(pos * 2 <= y && !visited[pos * 2]) {
                queue.offer(new int[]{pos * 2, dist + 1});
                visited[pos * 2] = true;
            }
            
            if(pos * 3 <= y && !visited[pos * 3]) {
                queue.offer(new int[]{pos * 3, dist + 1});
                visited[pos * 3] = true;
            }
            
        }
        
        return -1;
    }
}