class Solution {
    static int answer = 0;
    static int[] nums;
    
    public int solution(int[] nums) {
        this.nums = nums;
        combine(0, 0, 0);
        return answer;
    }
    
    private int isPrimeNumber(int num) {
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) return 0;
        }
        return 1;
    }
    
    private void combine(int depth, int start, int sum) {
        if(depth == 3) {
            answer += isPrimeNumber(sum); 
            return;
        }
        
        for(int i = start; i < nums.length; i++) {
            combine(depth+1, i+1, sum + nums[i]);
        }
    }
}