import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 1. 바깥쪽 {{}} 제거
        s = s.substring(2, s.length() - 2);
        
        // 2. 집합 단위로 분리 2 / 2,1 / 2,1,3
        String[] sets = s.split("\\},\\{");
        
        // 3. 원소 개수가 적은 집합부터 정렬 
        Arrays.sort(sets, (a, b) -> a.length() - b.length());
        
        // 4. 작은 집합부터 보면서 새로 등장한 숫자 추가
        Set<Integer> used = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        
        for(String set : sets) {
            String[] nums = set.split(",");
            
            for(String num : nums) {
                int value = Integer.parseInt(num);
                
                if(!used.contains(value)) {
                    used.add(value);
                    result.add(value);
                }
            }
        }
        
        // 5. int[]로 변환
        int[] answer = new int[result.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}