import java.io.*;

import java.util.*;

public class Main {

    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        // 파스칼 삼각형 미리 계산

        for(int i = 0; i <= 30; i++) {

            dp[i][0] = 1;

            dp[i][i] = 1;

            for(int j = 1; j < i; j++) {

                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];

            }

        }

        while(T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            int M = Integer.parseInt(st.nextToken());

            sb.append(dp[M][N]).append("\n");

        }

        System.out.print(sb);

    }

}