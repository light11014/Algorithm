import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 1. nums 배열로 종류 -> 개수 Map 생성
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // 2. N/2(최대 뽑을 수 있는 횟수)와 key 개수(종류 수) 중 작은 값 반환
        return Math.min(nums.length / 2, map.size());
    }
}