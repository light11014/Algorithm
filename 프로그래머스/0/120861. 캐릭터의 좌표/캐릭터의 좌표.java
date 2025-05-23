import java.util.*;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0, y = 0;
        
        HashMap<String, int[]> map = new HashMap<>();
        map.put("up", new int[]{0, 1});
        map.put("down", new int[]{0, -1});
        map.put("left", new int[]{-1, 0});
        map.put("right", new int[]{1, 0});
        
        int width = board[0] / 2;
        int height = board[1] / 2;
        
        for(String input : keyinput) {
            int[] move = map.get(input);
            
            if(Math.abs(x + move[0]) <= width && Math.abs(y + move[1]) <= height) {
                x += move[0];
                y += move[1];
            }
        }

        return new int[]{x, y};
    }
}