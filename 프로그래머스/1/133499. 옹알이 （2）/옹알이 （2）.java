class Solution {
    public int solution(String[] babbling) {
        String[] b = {"aya", "ye", "woo", "ma"};
        String[] bb = {"ayaaya", "yeye", "woowoo", "mama"};
        
        int answer = 0;
        
        for(String str : babbling) {
            boolean hasDouble = false;
            
            for(String bbstr : bb) {
                if(str.contains(bbstr)) {
                    hasDouble = true;
                    break;
                }
            }
            
            if(hasDouble) continue;
            
            for(String bstr : b) {
                str = str.replace(bstr, "#");
            }
            
            str = str.replace("#", "");
            
            if(str.isEmpty()) answer++;
        }
        
        return answer;
    }
}