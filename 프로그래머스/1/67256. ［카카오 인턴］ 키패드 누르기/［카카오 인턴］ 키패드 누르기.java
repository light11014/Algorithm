class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int left = 10;
        int right = 12;
        
        for(int num : numbers) {
            if(num == 0) {
                num = 11;
            } 
            
            if(num % 3 == 1) {
                answer.append("L");
                left = num;
            } else if(num % 3 == 0) {
                answer.append("R");
                right = num;
            } else {
                int leftDist = getDistance(left, num);
                int rightDist = getDistance(right, num);
                
                if(leftDist < rightDist || 
                   (leftDist == rightDist && hand.equals("left"))) {
                    answer.append("L");
                    left = num;
                } else {
                    answer.append("R");
                    right = num;
                }
            }
        }     
        return answer.toString();
    }
    
    private int getDistance(int from, int to) {
        int fromRow = (from - 1) / 3;
        int fromCol = (from - 1) % 3;
        
        int toRow = (to - 1) / 3;
        int toCol = (to - 1) % 3;
        
        return Math.abs(fromRow - toRow) + Math.abs(fromCol - toCol);
    }
}