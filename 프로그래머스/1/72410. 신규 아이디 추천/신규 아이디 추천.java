import java.util.*;

class Solution {
    public String solution(String new_id) {        
        new_id = new_id.toLowerCase();
        
        new_id = new_id.replaceAll("[^0-9a-z._-]", "");
        
        new_id = new_id.replaceAll("\\.{2,}", ".");
        
        if(new_id.startsWith(".")) {
            new_id = new_id.substring(1);
        }
                
        if(new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
                
        if(new_id.isEmpty()) {
            new_id = "a";
        }
        
        if(new_id.length() >= 16) {
            if(new_id.charAt(14) == '.') {
                new_id = new_id.substring(0, 14);
            } else {
                new_id = new_id.substring(0, 15);
            }
        }
        
        while(new_id.length() <= 2) {
            new_id = new_id + new_id.charAt(new_id.length() - 1);
        }
            
        return new_id;
    }
}