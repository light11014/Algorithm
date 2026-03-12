import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        int min = -1;

        for(int i = M; i <= N; i++) {
            if(isPrime(i)) {
                answer += i;

                if(min == -1) {
                    min = i;
                }
            }
        }
        System.out.println(answer == 0? -1 : answer + "\n" + min);
    }

    private static boolean isPrime(int i) {
        if(i == 1) return false;

        for(int j = 2; j * j <= i; j++) {
            if(i % j == 0)
                return false;
        }

        return true;
    }
}