import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        boolean[] spoiler = new boolean[message.length()];

        for (int[] range : spoiler_ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                spoiler[i] = true;
            }
        }

        Set<String> normalWords = new HashSet<>();
        Set<String> spoilerWords = new HashSet<>();

        int start = 0;

        while (start < message.length()) {
            int end = start;

            while (end < message.length() && message.charAt(end) != ' ') {
                end++;
            }

            String word = message.substring(start, end);

            boolean isSpoiler = false;

            for (int i = start; i < end; i++) {
                if (spoiler[i]) {
                    isSpoiler = true;
                    break;
                }
            }

            if (isSpoiler) {
                spoilerWords.add(word);
            } else {
                normalWords.add(word);
            }

            start = end + 1;
        }

        int answer = 0;

        for (String word : spoilerWords) {
            if (!normalWords.contains(word)) {
                answer++;
            }
        }

        return answer;
    }
}