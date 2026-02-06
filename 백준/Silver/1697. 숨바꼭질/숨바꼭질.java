import java.io.*;
import java.util.*;

public class Main {
    static int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, -1);
        queue.add(N);
        dist[N] = 0;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if(cur == K) {
                System.out.println(dist[K]);
                return;
            }

            if(validate(cur + 1) && dist[cur + 1] == -1) {
                queue.add(cur+1);
                dist[cur+1] = dist[cur] + 1;
            }

            if(validate(cur - 1) && dist[cur - 1] == -1) {
                queue.add(cur-1);
                dist[cur-1] = dist[cur] + 1;
            }

            if(validate(cur * 2) && dist[cur * 2] == -1) {
                queue.add(cur * 2);
                dist[cur * 2] = dist[cur] + 1;
            }

        }

    }

    private static boolean validate(int next) {
        return next >= 0 && next <= MAX;
    }
}