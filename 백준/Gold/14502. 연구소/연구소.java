import java.io.*;
import java.util.*;

public class Main {
    static int[][] lab;
    static int N;
    static int M;
    static int answer = 0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(lab[i][j] == 0) {
                    lab[i][j] = 1;
                    dfs(i, j, 1);
                    lab[i][j] = 0;
                }
            }
        }

        System.out.println(answer);

    }

    static class Virus {
        int x, y;

        public Virus(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }

    private static void dfs(int x, int y, int depth) {
        if(depth == 3) {
            // 바이러스 확인
            answer = Math.max(answer, bfs());
            return;
        }

        for(int i = x; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(i == x && j <= y) continue;

                if(lab[i][j] == 0) {
                    lab[i][j] = 1;
                    dfs(i, j, depth + 1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    private static int bfs() {
        boolean[][] visited = new boolean[N][M];
        Queue<Virus> queue = new ArrayDeque<>();

        int wallCount = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(lab[i][j] == 2) {
                    queue.add(new Virus(i, j));
                } else if (lab[i][j] == 1) {
                    wallCount++;
                }
            }
        }

        int virusCount = queue.size();

        while(!queue.isEmpty()) {
            Virus cur = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(lab[nx][ny] != 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.add(new Virus(nx, ny));
                virusCount++;
            }
        }

        return N * M - virusCount - wallCount;
    }
}