import java.io.*;
import java.util.*;

public class Main {
    static int[] lines;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        lines = new int[K];

        int max = 0;
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lines[i]);
        }

        long left = 1;  // 탐색할 영역의 시작
        long right = max;  // 탐색 안한 영역의 끝
        long answer = 0; //  가능한 최대값

        while(left <= right) {
            long mid = (left + right) / 2;

            if(canMake(mid, N)) {
                answer = mid; // 가능한 값 -> 답 후보
                left = mid + 1; // 더 큰 값 탐색
            } else {
                right = mid - 1; // 불가능한 값
            }
        }

        System.out.println(answer);
    }

    private static boolean canMake(long length, int N) {
        long result = 0;
        for (int line : lines) {
            result += line / length;
        }
        return result >= N;
    }
}
