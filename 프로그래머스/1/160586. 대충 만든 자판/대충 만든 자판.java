class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for(int i = 0; i < targets.length; i++) {
            for(String str : targets[i].split("")) {
                int minIndex = Integer.MAX_VALUE;
                
                for(String km : keymap) {
                    int idx = km.indexOf(str);
                    if(idx != -1) {
                        minIndex = Math.min(minIndex, idx);
                    }
                }
                
                if(minIndex == Integer.MAX_VALUE) {
                    answer[i] = -1;
                    break;
                } else {
                    answer[i] += minIndex + 1;
                }
            }
        }
        
        return answer;
    }
}