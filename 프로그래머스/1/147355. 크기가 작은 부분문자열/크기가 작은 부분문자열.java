class Solution {
    public int solution(String t, String p) {
        int N = p.length();
        long pNum = Long.parseLong(p);
        int answer = 0;
        
        for(int i = 0; i <= t.length() - N; i++) {
            long tNum = Long.parseLong(t.substring(i, i + N));
            if(pNum >= tNum) {
                answer++;
            }
        }
        
        return answer;
    }
}