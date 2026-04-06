import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] room;
    static boolean[][] cleaned;

    // 북 / 동 / 남 / 서
    static int[] dr= {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        cleaned = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while(true) {
            // 1. 현재칸이 청소 안됨 -> 청소
            if(!cleaned[r][c]) {
                cleaned[r][c] = true;
                answer++;
            }

            boolean moved = false;

            // 3. 4칸 중 청소되지 않은 빈칸 존재
            for(int i = 0; i < 4; i++) {
                // 반시계 방향 회전
                dir = (dir + 3) % 4;

                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if(room[nr][nc] == 0 && !cleaned[nr][nc]) {
                    r = nr;
                    c = nc;
                    moved = true;
                    break;
                };
            }

            // 2. 청소된 칸 없음 -> 후진
            if(!moved) {
                int nr = r - dr[dir];
                int nc = c - dc[dir];

                if(room[nr][nc] == 1) break;

                r = nr;
                c = nc;
            }
        }

        System.out.println(answer);
    }
}