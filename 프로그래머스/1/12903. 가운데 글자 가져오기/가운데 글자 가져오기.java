class Solution {
    public String solution(String s) {
        int N = s.length();
        
        if(N % 2 == 0) {
            return s.substring(N / 2 - 1, N / 2 + 1);
        } else {
            return s.charAt(N / 2) + "";
        }
    }
}