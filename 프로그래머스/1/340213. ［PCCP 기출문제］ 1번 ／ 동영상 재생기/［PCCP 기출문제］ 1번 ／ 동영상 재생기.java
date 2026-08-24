class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int videoSec = toSeconds(video_len);
        int posSec = toSeconds(pos);
        int opStartSec = toSeconds(op_start);
        int opEndSec = toSeconds(op_end);
        
        posSec = skipOpening(posSec, opStartSec, opEndSec);

        for(String command : commands) {
            if(command.equals("prev")) {
                posSec = Math.max(0, posSec - 10);
            } else {
                posSec = Math.min(videoSec, posSec + 10);
            }
            
            posSec = skipOpening(posSec, opStartSec, opEndSec);
        }
        
        return toTimeString(posSec);
    }
    
    private int toSeconds(String time) {
        String[] split = time.split(":");
        
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
    
    private int skipOpening(int pos, int start, int end) {
        if (start <= pos && pos <= end) {
            return end;
        }

        return pos;
    }
    
    private String toTimeString(int seconds) {
        return String.format("%02d:%02d", seconds / 60, seconds % 60); 
    }
}