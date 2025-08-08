import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            arr[i] = num;
        }

        Arrays.sort(arr);
        int except = round(N * 0.15);
        for(int i = 0; i < except; i++) {
            sum -= arr[i];
            sum -= arr[N - i - 1];
        }
        System.out.println(round((double)sum / (N - 2 * except)));
    }

    private static int round(double a) {
        return (int)(a + 0.5);
    }
}