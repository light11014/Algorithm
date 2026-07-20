class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            int result = arr1[i] | arr2[i];
            String str = Integer.toBinaryString(result);
            
            StringBuilder sb = new StringBuilder();
            
            if(str.length() < n)
                sb.append(" ".repeat(n - str.length()));
            
            for(char c : str.toCharArray()) {
                sb.append((c == '0')? " " : "#");
            }
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}