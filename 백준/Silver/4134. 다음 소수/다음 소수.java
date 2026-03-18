import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        while(N-- > 0) {
            long num = Long.parseLong(br.readLine());

            while(!isPrime(num)) {
                num++;
            };

            System.out.println(num);
        }

    }

    private static boolean isPrime(long num) {
        if(num <= 1) return false;
        else if(num == 2 || num == 3) return true;

        for(long i = 2; i * i <= num; i++) {
            if(num % i == 0)
                return false;
        }

        return true;
    }
}