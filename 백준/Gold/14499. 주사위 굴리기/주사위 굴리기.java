import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 위, 아래, 좌, 우, 앞, 뒤
        int[] dice = new int[6];

        st = new StringTokenizer(br.readLine());

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        while(K-- > 0) {
            int dir = Integer.parseInt(st.nextToken());

            // 방향으로 갈 수 있는지 확인
            int nx = x + dx[dir-1];
            int ny = y + dy[dir-1];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                continue;

            x = nx;
            y = ny;

            // 위, 아래, 좌, 우, 앞, 뒤
            if(dir == 1) { // 동
                int tmp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[1];
                dice[1] = dice[3];
                dice[3] = tmp;
            } else if (dir == 2) { // 서
                int tmp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[1];
                dice[1] = dice[2];
                dice[2] = tmp;
            } else if (dir == 3) { // 북
                int tmp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[1];
                dice[1] = dice[5];
                dice[5] = tmp;
            } else { // dir == 4
                int tmp = dice[0];
                dice[0] = dice[5];
                dice[5] = dice[1];
                dice[1] = dice[4];
                dice[4] = tmp;
            }

            if(map[x][y] == 0) {
                map[x][y] = dice[1];
            } else {
                dice[1] = map[x][y];
                map[x][y] = 0;
            }

            System.out.println(dice[0]);
        }

    }
}