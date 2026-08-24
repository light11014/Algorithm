class Solution {
    public int solution(int n, int w, int num) {        
        int targetRow = (num - 1) / w;
        int targetCol = targetRow % 2 == 0
                        ? (num - 1) % w 
                        : (w - 1) - (num - 1) % w;
        
        int fullRows = n / w;
        int remain = n % w;
        
        int answer = fullRows - targetRow;
        
        if(remain > 0) {
            if(fullRows % 2 == 0) {
                if(targetCol < remain) {
                    answer++;
                }
            } else {
                if(targetCol >= w - remain) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}