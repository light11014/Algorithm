import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scores = new int[N];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            sum += scores[i];
            if(max < scores[i]) {
                max = scores[i];
            }
        }

        System.out.println(((double)sum / (max * N)) * 100);
    }
}