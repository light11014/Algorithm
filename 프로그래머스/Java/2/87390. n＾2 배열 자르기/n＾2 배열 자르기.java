class Solution {
    public int[] solution(int n, long left, long right) {        
        int[] answer = new int[(int)(right - left) + 1];
        
        int i = 0;
        for(long l = left; l <= right; l++) {
            int row = (int)(l / n);
            int col = (int)(l % n);
            answer[i++] = Math.max(row, col) + 1;
        }
        return answer;
    }
}