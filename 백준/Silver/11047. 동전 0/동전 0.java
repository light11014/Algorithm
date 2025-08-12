import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        int[] coins = new int[N];
        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int idx = N - 1;
        int answer = 0;
        while(K > 0) {
            answer += K / coins[idx];
            K %= coins[idx];
            idx--;
        }

        System.out.println(answer);
    }
}