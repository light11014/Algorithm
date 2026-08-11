import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int[] attack : attacks) {
            map.put(attack[0], attack[1]);
        }
        
        int currentHealth = health;
        int combo = 0;
        
        for(int t = 1; t <= attacks[attacks.length - 1][0]; t++) {
            if(map.containsKey(t)) {
                currentHealth -= map.get(t);
                combo = 0;
                
                if(currentHealth <= 0) {
                    return -1;
                }
            } else {
                currentHealth = Math.min(currentHealth + bandage[1], health);
                combo++;
                
                if(combo == bandage[0]) {
                    currentHealth = Math.min(currentHealth + bandage[2], health);
                    combo = 0;
                }
            }
        }
        
        return currentHealth;
    }
}