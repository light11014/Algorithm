
class Solution {
    public int[] solution(int brown, int yellow) {
         for(int yh = 1; yh <= Math.sqrt(yellow); yh++) {
            if(yellow % yh != 0) continue;
            
            int yw = yellow / yh;
            
            if((yw + yh + 2) * 2 == brown) {
                return new int[]{yw + 2, yh + 2};
            } 
        }
        return null;
    }
}