class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int posMin = getMinutes(pos);
        int videoMin = getMinutes(video_len);
        
        int startMin = getMinutes(op_start);
        int endMin = getMinutes(op_end);
        
        if(startMin <= posMin && posMin <= endMin) {
            posMin = endMin;
        }
        
        for(String command : commands) {
            if(command.equals("prev")) {
                posMin = Math.max(0, posMin - 10);
            } else {
                posMin = Math.min(videoMin, posMin + 10);
            }
            
            if(startMin <= posMin && posMin <= endMin) {
                posMin = endMin;
            }
        }
        
        return toTimeString(posMin);
    }
    
    private int getMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
    
    private String toTimeString(int min) {
        return String.format("%02d:%02d", min / 60, min % 60); 
    }
}