import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        return Math.min((int)Arrays.stream(nums).boxed().distinct().count(), nums.length/2);
    }
}