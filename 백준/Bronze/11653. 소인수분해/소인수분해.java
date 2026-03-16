import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 2; i * i <= N; i++) {
            while(N % i == 0) {
                N /= i;
                System.out.println(i);
            }
        }

        if(N > 1) {
            System.out.println(N);
        }
    }
}