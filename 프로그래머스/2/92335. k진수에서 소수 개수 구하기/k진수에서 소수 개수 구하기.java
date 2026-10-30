class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String str = Integer.toString(n, k);
        
        long num = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != '0') {
                num = num * 10 + (str.charAt(i) - '0');
                continue;
            } 
            
            if(isPrime(num)) {
                answer++;
            }
            
            num = 0;
        }
        
        return isPrime(num)? answer + 1 : answer;
    }
    
    private boolean isPrime(long num) {
        if(num <= 1) return false;
        else if(num == 2 || num == 3) return true;
        
        for(long i = 2; i * i <= num; i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}