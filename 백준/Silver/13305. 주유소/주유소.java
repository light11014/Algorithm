import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] lengths = new int[N];
        int[] prices = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N; i++) {
            lengths[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int minPrice = prices[0];
        long answer = 0;
        for(int i = 1; i < N; i++) {
            answer += (long)minPrice * lengths[i];
            minPrice = Math.min(prices[i], minPrice);
        }
        System.out.println(answer);
    }
}