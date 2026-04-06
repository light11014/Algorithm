import java.io.*;
import java.util.*;

public class Main {
    static int[][] room;
    static int N;
    static int M;

    // 북 / 동 / 남 / 서
    static int[] dr= {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        room = new int[N][M];

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(r, c));
        boolean[][] cleaned = new boolean[N][M];

        int answer = 1;
        cleaned[r][c] = true;

        while(!queue.isEmpty()) {
            Point cur = queue.poll();

            // 3번: 4칸 중 청소되지 않은 빈칸 존재
            for(int i = 0; i < 4; i++) {
                // 반시계 방향 회전
                dir = (dir + 3) % 4;

                int nr = cur.r + dr[dir];
                int nc = cur.c + dc[dir];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(cleaned[nr][nc] || room[nr][nc] == 1) continue;
                
                // 청소
                answer++;
                queue.add(new Point(nr, nc));
                cleaned[nr][nc] = true;
                break;
            }

            // 2번: 청소된 칸 없음 -> 후진
            if(queue.isEmpty()) {
                int nr = cur.r - dr[dir];
                int nc = cur.c - dc[dir];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || room[nr][nc] == 1) break;

                queue.add(new Point(nr, nc));
            }
        }

        System.out.println(answer);

    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r=r;
            this.c=c;
        }
    }
}