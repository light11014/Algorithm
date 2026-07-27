class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()) {
            for(int i = 0; i < index; i++) {
                c = (char)('a' + (c - 'a' + 1) % 26);
                while(skip.contains(String.valueOf(c))) {
                    c = (char)('a' + (c - 'a' + 1) % 26);
                }
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
}