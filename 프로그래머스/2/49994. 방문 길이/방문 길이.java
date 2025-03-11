import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        HashMap<String, int[]> map = new HashMap<>(); 
        map.put("U", new int[]{0, 1});
        map.put("D", new int[]{0, -1});
        map.put("R", new int[]{1, 0});
        map.put("L", new int[]{-1, 0});
        
        int[] pos = {0, 0};
        
        // 1. dirs 하나씩 탐색하기
        // 1-1. 넘어가는 위치인지 확인
        // 1-2. 중복이 있는지 확인(양방향)
        HashSet<String> set = new HashSet<>();
        for(String d : dirs.split("")) {
            int[] offset = map.get(d);
            
            if(isValid(pos, offset)) {
                int nx = pos[0] + offset[0];
                int ny = pos[1] + offset[1];
                
                set.add(pos[0] + " " + pos[1] + " " + nx + " " + ny);
                set.add(nx + " " + ny + " " + pos[0] + " " + pos[1]);
                
                pos[0] = nx;
                pos[1] = ny;
            }
        }
        
        // 1-3. 방향 무시
        return set.size()/2;
    }
    
    private boolean isValid(int[] player, int[] offset) {
        for(int i = 0; i < 2; i++) {
            if(-5 > player[i] + offset[i] || player[i] + offset[i] > 5) 
                return false;
        }
        return true;
    }
}