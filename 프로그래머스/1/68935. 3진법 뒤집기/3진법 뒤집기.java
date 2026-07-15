class Solution {
    public int solution(int n) {
        String n3 = Integer.toString(n, 3);
        String reverseN3 = new StringBuilder(n3).reverse().toString();
        return Integer.parseInt(reverseN3, 3);
    }
}