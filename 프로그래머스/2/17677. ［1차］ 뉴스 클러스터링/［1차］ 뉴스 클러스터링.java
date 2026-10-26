import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = makeMultiSet(str1);
        Map<String, Integer> map2 = makeMultiSet(str2);

        int intersection = 0;
        int union = 0;

        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        for (String key : keys) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);

            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }

        return union == 0
                ? 65536
                : intersection * 65536 / union;
    }

    private Map<String, Integer> makeMultiSet(String str) {
        Map<String, Integer> map = new HashMap<>();
        str = str.toLowerCase();

        for (int i = 0; i < str.length() - 1; i++) {
            char first = str.charAt(i);
            char second = str.charAt(i + 1);

            if (!isAlphabet(first) || !isAlphabet(second)) {
                continue;
            }

            String element = str.substring(i, i + 2);
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        return map;
    }

    private boolean isAlphabet(char c) {
        return 'a' <= c && c <= 'z';
    }
}