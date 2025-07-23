import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if(isPrimeNumber(number)) count++;
        }
        System.out.println(count);
    }

    private static boolean isPrimeNumber(int num) {
        if(num == 1) return false;
        else if (num == 2) return true;

        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}