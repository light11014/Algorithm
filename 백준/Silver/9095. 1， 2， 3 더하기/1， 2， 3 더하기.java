import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[12];
        dp[1] = 1; // 1
        dp[2] = 2; // 1+1, 2
        dp[3] = 4; // 1+1+1, 2+1, 1+2, 3
        /**
         * 마지막 숫자를 기준으로 구분 -> 1, 2, 3
         * dp[n-1] + 1
         * dp[n-2] + 2
         * dp[n-3] + 3
         * => dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
         */
        // 4 = (1)+3, [(1+1) + 2, (2)+2], dp[3] + 1

        for(int i = 4; i < 12; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}