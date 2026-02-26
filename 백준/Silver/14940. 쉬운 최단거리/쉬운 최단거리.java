import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][M];

        int[] goal = null;
        int[][] dist = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;

                if(num == 2) {
                    goal = new int[]{i, j};
                    dist[i][j] = 0;
                } else if(num == 0) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = -1;
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(goal);

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];

            for(int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }

                if(dist[nr][nc] != -1) {
                    continue;
                }

                dist[nr][nc] = dist[cr][cc] + 1;
                queue.add(new int[]{nr, nc});
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}