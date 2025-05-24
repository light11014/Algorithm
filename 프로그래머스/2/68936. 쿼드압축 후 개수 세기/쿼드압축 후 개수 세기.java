import java.util.*;

class Solution {
    private static int[][] ARR;
    private static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        ARR = arr;
        compress(0, 0, arr.length);
        return answer;
    }
    
    private void compress(int x, int y, int n) {
        int start = ARR[x][y];
        
        if(n == 1) {
            answer[start]++;
            return;
        }
        
        A: for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(start != ARR[x+i][y+j]) {
                    start = ARR[x+i][y+j];
                    break A;
                }
            }
        }
        
        if(start == ARR[x][y]) {
            answer[start]++;
        } else {
            compress(x, y, n/2);
            compress(x+n/2, y, n/2);
            compress(x, y+n/2, n/2);
            compress(x+n/2, y+n/2, n/2);
        }
    }
}