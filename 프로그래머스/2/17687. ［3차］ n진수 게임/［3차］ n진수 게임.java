class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder game = new StringBuilder();
        
        for (int num = 0; game.length() < t * m; num++) {
            game.append(Integer.toString(num, n).toUpperCase());
        }
        
        StringBuilder answer = new StringBuilder();

        for (int i = p - 1; answer.length() < t; i += m) {
            answer.append(game.charAt(i));
        }
        
        return answer.toString();
    }
}