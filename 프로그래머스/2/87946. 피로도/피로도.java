import java.util.*;

class Solution {
    boolean[] visited = null;
    int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        exploreDungeons(k, dungeons, 0);
        return max;
    }
    
    private void exploreDungeons(int k, int[][] dungeons, int count) {
        if(max < count) {
            max = count;
        }
        
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                exploreDungeons(k - dungeons[i][1], dungeons, count+1);
                visited[i] = false;
            }
        }
    }
}