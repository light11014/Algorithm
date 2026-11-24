import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        
        dfs(numbers, visited, 0);
  
        int answer = 0;
        
        for(int num : set) {
            if(isPrimeNumber(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(String numbers, boolean[] visited, int current) {
        set.add(current);
        
        for(int i = 0; i < numbers.length(); i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            dfs(numbers, visited, current * 10 + (numbers.charAt(i) - '0'));
            visited[i] = false;
        }
    }
    
    private boolean isPrimeNumber(int num) {
        if(num <= 1) return false;
        
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0)
                return false;
        }
        
        return true;
    }
}