import java.util.*;

class Solution {
    public int solution(String dirs) {
        Map<Character, Integer[]> map = new HashMap<>();
        map.put('U', new Integer[]{-1, 0});
        map.put('D', new Integer[]{1, 0});
        map.put('R', new Integer[]{0, 1});
        map.put('L', new Integer[]{0, -1});
        
        Set<String> set = new HashSet<>();
        
        int[] pos = {0, 0};
        int answer = 0;
        
        for(char dir : dirs.toCharArray()) {
            Integer[] offset = map.get(dir);
            
            int nx = pos[0] + offset[0];
            int ny = pos[1] + offset[1];
            
            if(nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            if(set.add(makeRoad(pos[0], pos[1], nx, ny))) {
                answer++;
            }
            
            pos[0] = nx;
            pos[1] = ny;
        }
        
        return answer;
    }
    
    private String makeRoad(int sx, int sy, int nx, int ny) {
        if(sx < nx || (sx == nx && sy <= ny)) {
            return sx + " " + sy + " " + nx + " " + ny;
        } else {
            return nx + " " + ny + " " + sx + " " + sy;   
        }
    }
}