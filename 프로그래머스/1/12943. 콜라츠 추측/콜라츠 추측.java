class Solution {
    public int solution(int num) {
        long number = num;
        for(int i = 0; i < 500; i++) {
            if(number == 1) return i;
            else if(number % 2 == 0) number /= 2;
            else number = number * 3 + 1;
        }    
        return -1;
    }
}