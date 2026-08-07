import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        Map<Character, int[]> directions = new HashMap<>();
        
        directions.put('N', new int[]{-1, 0});
        directions.put('S', new int[]{1, 0});
        directions.put('W', new int[]{0, -1});
        directions.put('E', new int[]{0, 1});
        
        int x = 0, y = 0;
        
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        
        for(String route : routes) {
    
            String[] split = route.split(" ");
            
            char dir = split[0].charAt(0);
            int distance  = Integer.parseInt(split[1]);
            
            int[] d = directions.get(dir);
            
            int nx = x;
            int ny = y;
            boolean possible = true;
            
            for(int i = 0; i < distance; i++) {
                nx += d[0];
                ny += d[1];
                
                if(0 > nx || nx >= park.length 
                   || 0 > ny || ny >= park[0].length() 
                   || park[nx].charAt(ny) == 'X') {
                    possible = false;
                    break;
                }
            }
            
            if(possible) {
                x = nx;
                y = ny;
            }            
        }
        
        return new int[]{x, y};
    }
}