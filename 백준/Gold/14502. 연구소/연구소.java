import java.io.*;
import java.util.*;

public class Main {
    static int[][] lab;
    static int N;
    static int M;
    static int answer = 0;

    static List<Point> emptyList = new ArrayList<>();
    static List<Point> virusList = new ArrayList<>();

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

                if(lab[i][j] == 0) {
                    emptyList.add(new Point(i, j));
                } else if(lab[i][j] == 2) {
                    virusList.add(new Point(i, j));
                }
            }
        }

        dfs(0, 0);

        System.out.println(answer);

    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }

    private static void dfs(int start, int depth) {
        if(depth == 3) {
            answer = Math.max(answer, bfs());
            return;
        }

        for(int i = start; i < emptyList.size(); i++) {
            Point p = emptyList.get(i);

            lab[p.x][p.y] = 1;
            dfs(i + 1, depth + 1);
            lab[p.x][p.y] = 0;
        }
    }

    private static int bfs() {
        boolean[][] visited = new boolean[N][M];
        Queue<Point> queue = new ArrayDeque<>();

        for(Point virus : virusList) {
            queue.add(virus);
            visited[virus.x][virus.y] = true;
        }

        int infectedCount = 0;

        while(!queue.isEmpty()) {
            Point cur = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny] || lab[nx][ny] != 0) continue;

                visited[nx][ny] = true;
                queue.add(new Point(nx, ny));
                infectedCount++;
            }
        }

        return emptyList.size() - 3 - infectedCount;
    }
}