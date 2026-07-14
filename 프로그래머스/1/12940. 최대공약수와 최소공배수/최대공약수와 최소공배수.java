class Solution {
    public int[] solution(int n, int m) {
        int GCD = gcd(n, m);
        return new int[]{GCD, n * m / GCD};
    }
    
    private int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}