class Solution {
    public String solution(int a, int b) {
        String[] daystr = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU", };
        int[] monthToDays = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int diff = b - 1;
        for(int month = 1; month < a; month++) {
            diff += monthToDays[month];
        }
        
        return daystr[diff % 7];
    }
}