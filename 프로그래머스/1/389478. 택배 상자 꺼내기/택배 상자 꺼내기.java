class Solution {
    public int solution(int n, int w, int num) {        
        int y = (num - 1) / w;
        int x = y % 2 == 0? (num - 1) % w : (w - 1) - (num - 1) % w;
        
        int count = n / w - y;
        
        
        if(n % w != 0) {
            if((n / w) % 2 == 0) {
                if(x < n % w) {
                    count++;
                }
            } else {
                if(x >= w - n % w) {
                    count++;
                }
            }
        }
        
        return count;
    }
}