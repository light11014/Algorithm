class Solution {
    public String solution(String X, String Y) {        
        int[] Xcount = new int[10];
        int[] Ycount = new int[10];
        
        for(char c : X.toCharArray()) {
            Xcount[c - '0']++;
        }
        
        for(char c : Y.toCharArray()) {
            Ycount[c - '0']++;
        }
        
        int[] nums = new int[10];
        
        for(int i = 0; i < 10; i++) {
            nums[i] = Math.min(Xcount[i], Ycount[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            if(nums[i] != 0) {
                sb.append(String.valueOf(i).repeat(nums[i]));
            }
        }

        if(sb.isEmpty()) {
            return "-1";
        } else if(sb.charAt(0) == '0') {
            return "0";
        } else {
            return sb.toString();
        }
    }
}