import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int N;
    static int M;
    static int answer = 0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, board[i][j]);
                visited[i][j] = false;

                checkT(i, j);
            }
        }



        System.out.println(answer);

    }

    private static void checkT(int x, int y) {
        int sum = board[x][y]; // 중심
        int wingCount = 0;
        int minWing = Integer.MAX_VALUE;

        for(int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            wingCount++;
            sum += board[nx][ny];
            minWing = Math.min(minWing, board[nx][ny]);
        }

        if(wingCount == 3) {
            answer = Math.max(answer, sum);
            return;
        }

        if(wingCount == 4) {
            answer = Math.max(answer, sum - minWing);
        }

    }

    private static void dfs(int x, int y, int depth, int sum) {
        if(depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        // 현재 어디로 갈 수 있는지(상하좌우)
        for(int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 갈 수 있는 곳인지 체크
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, sum + board[nx][ny]);
            visited[nx][ny] = false;
        }

    }
}