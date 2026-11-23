class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        int[] arr = new int[n * 2];
        
        long sum1 = 0;
        long total = 0;
        
        for(int i = 0; i < n; i++) {
            arr[i] = queue1[i];
            arr[i + n] = queue2[i];
            
            sum1 += queue1[i];
            total += queue1[i] + queue2[i];
        }
        
        if(total % 2 != 0) return -1;
        
        long target = total / 2;
        
        int left = 0;
        int right = n;
        int count = 0;
        
        while(count < 4 * n) {
            if(sum1 == target) {
                return count;
            }
            
            if(sum1 > target) {
                sum1 -= arr[left % (2 * n)];
                left++;
            } else {
                sum1 += arr[right % (2 * n)];
                right++;
            }
            
            count++;
        }
        
        return -1;
    }
}