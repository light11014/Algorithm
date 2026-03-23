import java.io.*;
import java.util.*;

public class Main {
    static int gcd(int a, int b) {
        return b == 0? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int[] nums = new int[N];

            for(int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;

            for(int i = 0; i < N-1; i++) {
                for(int j = i + 1; j < N; j++) {
                    sum += gcd(nums[i], nums[j]);
                }
            }

            System.out.println(sum);
        }

    }
}