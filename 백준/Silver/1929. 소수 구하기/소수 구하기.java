import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int i = M; i <= N; i++) {
            if(isPrimeNumber(i)) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean isPrimeNumber(int num) {
        if(num == 1) return false;
        if(num == 2 || num == 3) return true;
        if(num % 2 == 0 || num % 3 == 0) return false;
        for(int i = 5; i * i <= num; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}