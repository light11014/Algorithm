class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i=0; i<answer.length; i++) {
            for(int j=0; j<answer[0].length; j++) {
                for(int s=0; s<arr2.length; s++) 
                    answer[i][j] += arr1[i][s] * arr2[s][j];
            }
        }
        return answer;
    }
}