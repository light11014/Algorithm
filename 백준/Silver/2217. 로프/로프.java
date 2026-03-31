import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];

        for(int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);

        long maxWeight = 0;
        for(int i = 0; i < N; i++) {
            maxWeight = Math.max(maxWeight, (long) ropes[i] * (N - i));
        }

        System.out.println(maxWeight);

    }
}