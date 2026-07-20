class Solution {
    public int solution(String word) {
        int[] weight = {781, 156, 31, 6, 1};
        String vowels = "AEIOU";
        int answer = 0;
        
       for(int i = 0; i < word.length(); i++) {
           int vowelIndex = vowels.indexOf(word.charAt(i));
           answer += vowelIndex * weight[i] + 1;
       }
        
        return answer;
    }
}