import java.io.*;
import java.util.*;

public class Main {

    static long gcd(long a, long b) {
        return b == 0? a : gcd(b, a % b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            long gcd = gcd(a, b);
            long lcm = a / gcd * b;

            System.out.println(lcm);
        }

    }
}