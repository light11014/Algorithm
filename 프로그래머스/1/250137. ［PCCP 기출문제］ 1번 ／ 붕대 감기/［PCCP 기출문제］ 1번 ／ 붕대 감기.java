import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {       
        int currentHealth = health;
        int combo = 0;
        int attackIndex = 0;
        
        for(int t = 1; t <= attacks[attacks.length - 1][0]; t++) {
            if(t == attacks[attackIndex][0]) {
                currentHealth -= attacks[attackIndex][1];
                combo = 0;
                attackIndex++;
                
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