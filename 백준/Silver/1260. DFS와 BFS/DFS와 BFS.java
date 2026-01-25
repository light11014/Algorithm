import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] map;
    private static boolean[] vistied;

    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();

        map = new int[N+1][N+1];
        vistied = new boolean[N+1];

        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            map[i][j] = 1;
            map[j][i] = 1;
        }

        vistied[V] = true;
        sb.append(V);
        dfs(V);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }

    private static void dfs(int v) {
        for (int i = 1; i < map.length; i++) {
            if(map[v][i] == 1 && !vistied[i]) {
                vistied[i] = true;
                sb.append(" ").append(i);
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        vistied = new boolean[N+1];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.add(v);
        vistied[v] = true;
        sb.append(v);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 1; i < map.length; i++) {
                if(map[cur][i] == 1 && !vistied[i]) {
                    vistied[i] = true;
                    queue.add(i);
                    sb.append(" ").append(i);
                }
            }
        }
    }
}