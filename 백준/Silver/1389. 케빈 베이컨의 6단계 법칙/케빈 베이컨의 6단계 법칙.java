import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int answer = 0;
        int minSum = Integer.MAX_VALUE;

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            graph[i].add(j);
            graph[j].add(i);
        }

        for (int start = 1; start <= N; start++) {
            // 시작점: i
            int sum = bfs(start);

            if (sum < minSum) {
                minSum = sum;
                answer = start;
            }
        }

        System.out.println(answer);
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    queue.add(next);
                }
            }
        }

        int total = 0;
        for (int i = 1; i <= N; i++) {
            total += dist[i];
        }
        return total;
    }
}