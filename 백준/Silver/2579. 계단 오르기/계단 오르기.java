import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /*
        * 계단 오르는 규칙
        * 1) 한번에 한 계단 or 두 계단
        * 2) 연속된 세 계단 X
        * 3) 시작점은 계단 아님
        * 4) 마지막은 밟아야함
        * */

        /*
         * 4) 조건에 의해 거꾸로 가는게 좋지 않을까?
         * 연속은 어떻게 검증하지 => 이전 상태를 저장?
         * 최대 N번 => 연속 안됨
         * greedy는 아니고, 모든 케이스 살펴봐야함
         */

        // 입력 받기
        int[] stairs = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // 계단이 하나인 경우
        if(N == 1) {
            System.out.println(stairs[1]);
            return;
        }

        /**
         * i 번째 계단을 밟는 상황
         * 1) 1-2 -> i 로 오는 경우
         * 2) i-1 -> i 로 오는 경우
         * => 근데 2번은 i-2 -> i-1 -> i면 안되니까
         *     i-3 -> i-1 -> i 만 가능
         */

        int[] dp = new int[N+1];

        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2]; // non-decreasing

        if(N >= 3) {
            dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
            for(int i = 4; i <= N; i++) {
                dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];

            }
        }

        System.out.println(dp[N]);
    }
}