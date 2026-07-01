class Solution {
    public String solution(String phone_number) {
        int N = phone_number.length() - 4;
        return "*".repeat(N) + phone_number.substring(N);
    }
}