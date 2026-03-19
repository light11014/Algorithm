import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        long sum = 0;
        int count = 0;

        for(int i = 0; i < N; i++) {
            if(gcd(X, nums[i]) == 1) {
                sum += nums[i];
                count++;
            }
        }

        if(sum % count == 0)
            System.out.println(sum / count);
        else
            System.out.println((double) sum / count);
    }

    private static int gcd(int a, int b) {
        return b == 0? a : gcd(b, a % b);
    }
}