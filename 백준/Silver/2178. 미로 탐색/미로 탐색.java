import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) == '1';
            }
        }

        Queue<Point> queue = new ArrayDeque<>();
        int[][] dist = new int[N][M];


        // 시작점
        queue.add(new Point(0, 0));
        dist[0][0] = 1;
        map[0][0] = false;

        // 방향
        int[] rx = {1, -1, 0, 0};
        int[] ry = {0, 0, 1, -1};

        while(!queue.isEmpty()) {
            Point cur = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + rx[i];
                int ny = cur.y + ry[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || !map[nx][ny]) {
                    continue;
                }

                queue.add(new Point(nx, ny));
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                map[nx][ny] = false;

                if(nx == N - 1 && ny == M - 1) {
                    System.out.println(dist[N-1][M-1]);
                    return;
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
