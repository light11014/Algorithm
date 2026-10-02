class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] words = {"aya", "ye", "woo", "ma"};
        String[] repeatedWords = {"ayaaya", "yeye", "woowoo", "mama"};
        
        for(String b : babbling) {
            boolean hasDouble = false;
            
            for(String word : repeatedWords) {
                if(b.contains(word)) {
                    hasDouble = true;
                    break;
                }
            }
            
            if(hasDouble) continue;
            
            for(String word : words) {
                b = b.replace(word, "#");
            }
            
            b = b.replace("#", "");
            
            if(b.isEmpty()) answer++;
        }
        
        return answer;
    }
}