import java.io.*;

public class Main {
    static int[][] dp = new int[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(calculatePeople(k, n));
        }
    }
    private static int calculatePeople(int k, int n) {
        if(dp[k][n] != 0) return dp[k][n];

        if(k == 0) return dp[k][n] = n;
        if(n == 1) return dp[k][n] = 1;

        return dp[k][n] = calculatePeople(k, n - 1) + calculatePeople(k - 1, n);
    }
}