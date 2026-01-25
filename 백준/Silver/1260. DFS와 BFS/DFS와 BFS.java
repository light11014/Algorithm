import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] graph;
    static boolean[] vistied;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        vistied = new boolean[N+1];
        dfs(V);

        sb.append("\n");

        vistied = new boolean[N+1];
        bfs(V);

        System.out.println(sb);
    }

    private static void dfs(int v) {
        vistied[v] = true;
        sb.append(v).append(" ");

        for (int next : graph[v]) {
            if (!vistied[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int v) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(v);
        vistied[v] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");

            for (int next : graph[cur]) {
                if (!vistied[next]) {
                    vistied[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
