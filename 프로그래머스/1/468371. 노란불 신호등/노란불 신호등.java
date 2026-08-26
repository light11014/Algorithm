class Solution {
    public int solution(int[][] signals) { 
        int count = 1;
        
        int[][] signalArr = new int[signals.length][];
        
        for(int i = 0; i < signals.length; i++) {
            int[] signal = signals[i];
            int total = signal[0] + signal[1] + signal[2];
            count *= total;
            
            signalArr[i] = new int[total];
            
            int j = 0;
            for(int s = 0; s < 3; s++) {
                for(int c = 0; c < signal[s]; c++) {
                    signalArr[i][j++] = s;
                }
            } 
        }
           
        for(int i = 0; i < count; i++) {
            boolean off = true;
            
            for(int j = 0; j < signalArr.length; j++) {
                if(signalArr[j][i % signalArr[j].length] != 1) {
                    off = false;
                    break;
                }
            }
            
            if(off) {
                return i + 1;
            }
        }
        
        return -1;
    }
}