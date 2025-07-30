import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int gcd = A < B? gcd(A, B) : gcd(B, A);
        System.out.println(gcd);
        System.out.println(A * B / gcd);
    }

    private static int gcd(int a, int b) {
        if(b % a == 0)
            return a;
        else
            return gcd(b % a, a);
    }
}