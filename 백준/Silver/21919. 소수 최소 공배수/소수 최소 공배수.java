import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] removed = new boolean[1_000_001];

        for(int i = 2; i <= 1_000_000; i++) {
            if(removed[i]) continue;

            for(int j = i * 2; j <= 1_000_000; j += i) {
                if(!removed[j]) {
                    removed[j] = true;
                }
            }
        }

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long answer = 1;

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(!removed[num]) {
                removed[num] = true;
                answer *= num;
            }
        }

        System.out.println(answer == 1 ? -1 : answer);
    }
}