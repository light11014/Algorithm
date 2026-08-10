import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        
        for(int mat = mats.length - 1; mat >= 0; mat--) {
            int size = mats[mat];
            
            for(int i = 0; i <= park.length - size; i++) {
                for(int j = 0; j <= park[0].length - size; j++) {
                    if(canPlace(park, i, j, size)) {
                        return mats[mat];
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean canPlace(String[][] park, int startRow, int startCol, int size) {
        for(int i = startRow; i < startRow + size; i++) {
            for(int j = startCol; j < startCol + size; j++) {
                if(!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        
        return true;
    }
}