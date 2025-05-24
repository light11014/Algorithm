class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int d = n - 1;
        int p = n - 1;
        
        while (d >= 0 && deliveries[d] == 0) {
            d--;
        }
        while (p >= 0 && pickups[p] == 0) {
            p--;
        }
        
        while(d >= 0 || p >= 0) {
            answer += (Math.max(d, p) + 1) * 2L;
            d = getMaxIdx(cap, deliveries, d);
            p = getMaxIdx(cap, pickups, p);
        }
        
        return answer;
    }
    
    private static int getMaxIdx(int cap, int[] target, int idx) {
        while (idx >= 0 && (cap > 0 || target[idx] == 0)) {
            if (target[idx] > cap) {
                target[idx] -= cap;
                cap = 0;
            }
            else {
                cap -= target[idx];
                target[idx--] = 0;
            }
        }
        return idx;
    }
}