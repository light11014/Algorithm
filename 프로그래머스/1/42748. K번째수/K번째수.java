import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++) {
            int[] command = commands[i];
            int[] copyArr = Arrays.copyOfRange(array, command[0]-1, command[1]);
            Arrays.sort(copyArr);
            answer[i] = copyArr[command[2]-1];
        }
        return answer;
    }
}