import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }
        
        for(String calling : callings) {
            int current = rank.get(calling);
            int front = current - 1;
            
            String frontPlayer = players[front];
            players[current] = frontPlayer;
            players[front] = calling;
            
            rank.put(frontPlayer, current);
            rank.put(calling, front);
        }
        
        return players;
    }
}