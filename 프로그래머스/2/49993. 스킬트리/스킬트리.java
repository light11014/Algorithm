class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
       
        
        for(String skill_tree : skill_trees) {
            int idx = 0;
            boolean isPossible = true;
            
            for(int i = 0; i < skill_tree.length(); i++) {
                char c = skill_tree.charAt(i);
                
                if(c == skill.charAt(idx)) {
                    idx++;
                    
                    if(idx == skill.length()) {
                        break;
                    }
                } else if(skill.indexOf(c) != -1) {
                    isPossible = false;
                    break;
                }
            }
            
            if(isPossible) {
                answer++;
            }
        }
        return answer;
    }
}