import java.util.*;

class Solution {
    public int solution(String dirs) {
        Map<Character, int[]> map = new HashMap<>();
        map.put('U', new int[]{-1, 0});
        map.put('D', new int[]{1, 0});
        map.put('R', new int[]{0, 1});
        map.put('L', new int[]{0, -1});
        
        Set<String> set = new HashSet<>();
        
        int[] pos = {0, 0};
        
        for(char dir : dirs.toCharArray()) {
            int[] offset = map.get(dir);
            
            int nx = pos[0] + offset[0];
            int ny = pos[1] + offset[1];
            
            if(nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            set.add(makeRoad(pos[0], pos[1], nx, ny));
            
            pos[0] = nx;
            pos[1] = ny;
        }
        
        return set.size();
    }
    
    private String makeRoad(int sx, int sy, int nx, int ny) {
        if(sx < nx || (sx == nx && sy < ny)) {
            return sx + " " + sy + " " + nx + " " + ny;
        } else {
            return nx + " " + ny + " " + sx + " " + sy;   
        }
    }
}