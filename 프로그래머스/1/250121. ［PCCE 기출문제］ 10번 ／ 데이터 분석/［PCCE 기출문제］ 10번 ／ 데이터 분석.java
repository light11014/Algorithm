import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        int extIndex = map.get(ext);
        
        List<int[]> list = new ArrayList<>();
        
        for(int[] row : data) {
            if(row[extIndex] < val_ext) {
                list.add(row);
            }
        }
        
        int sortIndex = map.get(sort_by);
        
        list.sort(Comparator.comparingInt(row -> row[sortIndex]));
        
        return list.toArray(new int[list.size()][]);
    }
}