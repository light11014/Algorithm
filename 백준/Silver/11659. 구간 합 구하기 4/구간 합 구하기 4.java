import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] prefix = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            prefix[i] = prefix[i-1] + Long.parseLong(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(prefix[e] - prefix[s-1]).append("\n");
        }

        System.out.println(sb);
    }

}