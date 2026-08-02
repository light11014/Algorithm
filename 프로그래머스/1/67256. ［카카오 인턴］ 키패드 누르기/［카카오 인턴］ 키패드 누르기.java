class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int[] left = {3, 0};
        int[] right = {3, 2};
        
        for(int num : numbers) {
            
            if(num == 1 || num == 4 || num == 7) {
                left[0] = num / 3;
                left[1] = 0;
                answer.append("L");
                continue;
            }
            
            if(num == 3 || num == 6 || num == 9) {
                right[0] = (num - 1) / 3;
                right[1] = 2;
                answer.append("R");
                continue;
            }
            
            int leftDist = getDistance(left, num);
            int rightDist = getDistance(right, num);
            
            if(leftDist == rightDist) {
                if(hand.equals("left")) {
                    left[0] = num == 0? 3 : num / 3;
                    left[1] = 1;
                    answer.append("L");
                } else {
                    right[0] = num == 0? 3 : num / 3;
                    right[1] = 1;
                    answer.append("R");
                }
            } else if(leftDist < rightDist) {
                left[0] = num == 0? 3 : num / 3;
                left[1] = 1;
                answer.append("L");
            } else {
                answer.append("R");
                right[0] = num == 0? 3 : num / 3;
                right[1] = 1;
            }
            
        }
        
        return answer.toString();
    }
    
    private int getDistance(int[] hand, int target) {
        int result = Math.abs(hand[1] - 1);
        
        if(target == 2) {
            result += hand[0];
        } else if(target == 5) {
            result += Math.abs(hand[0] - 1);
        } else if(target == 8) {
            result += Math.abs(hand[0] - 2);
        } else {
            result += Math.abs(hand[0] - 3);
        }
        
        return result;
    }
}