class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()) {
            if(c == ' ') sb.append(c);
            else {
                char base = Character.isUpperCase(c)? 'A' : 'a';
                sb.append((char)(base + (c - base + n) % 26));
            }
        }

        return sb.toString();
    }
}