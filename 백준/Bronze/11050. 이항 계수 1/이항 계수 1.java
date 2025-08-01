import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(multiply(N, K) / factorial(K));
    }

    private static int factorial(int N) {
        int result = 1;
        for(int i = 1; i <= N; i++) {
            result *= i;
        }
        return result;
    }

    private static int multiply(int N, int count) {
        int result = 1;
        for(int i = 0; i < count; i++) {
            result *= (N - i);
        }
        return result;
    }
}